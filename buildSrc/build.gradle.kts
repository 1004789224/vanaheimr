// gradle使用kts
plugins {
    `kotlin-dsl`
}

// 插件使用仓库
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

// 依赖插件
dependencies {
    // 依赖spring-boot的插件
    implementation("com.github.jengelman.gradle.plugins:shadow:6.1.0")
    implementation("org.apache.logging.log4j:log4j-core:2.17.1")
    implementation("org.owasp:dependency-check-gradle:7.1.0.1")
    // ebean
    implementation("io.ebean:ebean:13.10.1")
}
