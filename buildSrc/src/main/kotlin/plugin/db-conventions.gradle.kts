import contstants.Version

plugins {
    id("java-conventions")
    kotlin("jvm")
//    id("org.jetbrains.kotlin.kapt")

}

val queryDslVersion = "5.0.0"

val implementation by configurations
val api by configurations
val annotationProcessor by configurations
val testImplementation by configurations
val runtimeOnly by configurations


dependencies {
    // postgresql
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.querydsl:querydsl-jpa:$queryDslVersion:jakarta")
    // querydsl
    annotationProcessor("com.querydsl:querydsl-apt:$queryDslVersion:jakarta")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api:3.1.0")
}