import contstants.Version

// 多模块项目
// 每个模块都有4个子模块
// 1. api
// 2. biz
// 3. model
// 4. boot

plugins {
    id("org.springframework.boot") version "2.7.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
    id("org.jetbrains.kotlin.plugin.spring") version "1.7.20" apply false
    // querydsl
    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10" apply false
    // kapt
    id("org.jetbrains.kotlin.kapt") version "1.7.20" apply false
    id("io.ebean") version "13.6.5" apply false
}


val realModule = kotlin.collections.listOf("api", "boot", "po", "biz")

val isCommon = project.name.replace("common", "").isNotBlank()
// 每个模块都依赖kotlin插件
allprojects {

    repositories {
        mavenLocal()
        if (System.getenv("GITHUB_WORKFLOW") == null) { // 普通环境
            maven(url = "https://mirrors.tencent.com/nexus/repository/maven-public")
            maven(url = "https://mirrors.tencent.com/nexus/repository/gradle-plugins/")
        } else { // GitHub Action 环境
            mavenCentral()
            gradlePluginPortal()
        }
    }

    if (realModule.contains(this.name) || isCommon) {

        apply(plugin = "io.spring.dependency-management")
        // kotlin
        apply(plugin = "kotlin")
        apply(plugin = "java")
        apply(plugin = "org.jetbrains.kotlin.kapt")
        // kotlin-spring
        apply(plugin = "org.jetbrains.kotlin.plugin.spring")
        // 如果是boot的模块，依赖spring-boot的插件
        if (project.name.endsWith("boot")) {
            apply(plugin = "org.springframework.boot")
        }
        // 统一使用java17
        tasks.withType<JavaCompile> {
            options.encoding = "UTF-8"
            sourceCompatibility = "17"
            targetCompatibility = "17"
        }
        // 使用spring-boot的依赖管理
        dependencyManagement {
            imports {
                mavenBom("org.springframework.boot:spring-boot-dependencies:${Version.SpringBoot}")
            }
        }
        // 统一使用kotlin17
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "17"
                apiVersion = "1.7"
                languageVersion = "1.7"
            }
        }
        val testImplementation by configurations
        val implementation by configurations
        val kapt by configurations

        // 测试使用junit5
        dependencies {
            testImplementation("org.springframework.boot:spring-boot-starter-test") {
                exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
            }
        }

        if (project.name.equals("po")) {
            // ebean
            apply(plugin = "io.ebean")
            dependencies {
                // ebean
                implementation("io.ebean:ebean:${Version.ebean}")
                kapt("io.ebean:kotlin-querybean-generator:${Version.ebean}")

                testImplementation("io.ebean:ebean-test:${Version.ebean}")
                // h2 driver
                testImplementation("com.h2database:h2")
            }

        }
        dependencies{
            testImplementation("org.springframework.boot:spring-boot-starter-test")
            testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")

        }
        tasks.withType<Test> {
            useJUnitPlatform()
        }
    }

}