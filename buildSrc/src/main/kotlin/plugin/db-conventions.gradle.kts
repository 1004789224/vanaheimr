import contstants.Version

plugins {
    id("java-conventions")
    kotlin("jvm")
    id("org.jetbrains.kotlin.kapt")
    // ebean
    id("io.ebean")
}


val implementation by configurations
val kapt by configurations
val testImplementation by configurations
val runtimeOnly by configurations


dependencies {
    runtimeOnly("mysql:mysql-connector-java")
    implementation("io.ebean:ebean:${Version.ebean}")
    kapt("io.ebean:kotlin-querybean-generator:13.6.5")
    testImplementation("io.ebean:ebean-test:${Version.ebean}")
    testImplementation("com.h2database:h2")

}