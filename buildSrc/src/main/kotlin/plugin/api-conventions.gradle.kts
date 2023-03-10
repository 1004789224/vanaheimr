plugins {
    id("java-conventions")
    // swagger-gradle-plugin
    id("io.swagger.core.v3.swagger-gradle-plugin")
}

dependencies {
    kapt("io.micronaut.serde:micronaut-serde-processor")
    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    // swagger-annotations
    implementation("io.swagger.core.v3:swagger-annotations:2.1.9")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("io.micronaut:micronaut-validation")
    api(project(":common:common-web"))
}



