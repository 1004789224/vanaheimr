import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    id("io.spring.dependency-management")
}
repositories {
    mavenLocal()
    maven {
        url = uri("https://maven.aliyun.com/repository/public")
    }

    mavenCentral()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

group = "io.vanaheimr"
version = "1.0.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.0.1"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}