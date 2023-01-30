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
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    // spring-gradle-plugin
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.0.1")
    // swagger-gradle-plugin
    implementation("io.swagger.core.v3:swagger-gradle-plugin:2.2.7")

}
