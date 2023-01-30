plugins {
    id("java-conventions")
    kotlin("jvm")
}

dependencies {
    api("org.eclipse.collections:eclipse-collections-api:11.1.0")
    api("org.springframework.boot:spring-boot-starter-validation")
    api("org.springframework.boot:spring-boot-starter")
    implementation("org.eclipse.collections:eclipse-collections:11.1.0")
    // jackson-databind
    implementation("com.fasterxml.jackson.core:jackson-databind")
}