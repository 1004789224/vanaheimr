ext {
    set("kotlin_version", "1.7.21")
}
// gradle使用kts
plugins {
    `kotlin-dsl`
}

// 插件使用仓库
repositories {
    gradlePluginPortal()
}

// 依赖插件
dependencies {
    // 依赖spring-boot的插件
    implementation("com.github.jengelman.gradle.plugins:shadow:6.1.0")
    implementation("org.apache.logging.log4j:log4j-core:2.17.1")
    implementation("org.owasp:dependency-check-gradle:7.1.0.1")
    // kotlin-gradle-plugin
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
    implementation("org.jetbrains.kotlin:kotlin-allopen:1.7.21")
    // micronaut-gradle-plugin
    implementation("io.micronaut.gradle:micronaut-gradle-plugin:3.6.7")
    // swagger-gradle-plugin
    implementation("io.swagger.core.v3:swagger-gradle-plugin:2.2.7")
    // jooq-gradle-plugin
    implementation("nu.studer:gradle-jooq-plugin:8.1")
    // flyway-gradle-plugin
    implementation("org.flywaydb:flyway-gradle-plugin:8.2.2")

}
