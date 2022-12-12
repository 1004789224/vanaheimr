import contstants.Version

apply(plugin="io.ebean")

apply(plugin="org.jetbrains.kotlin.kapt")

val implementation by configurations
val kapt by configurations
val testImplementation by configurations
val runtimeOnly by configurations


dependencies {
    runtimeOnly("mysql:mysql-connector-java")
    implementation("io.ebean:ebean:${Version.ebean}")
    kapt("io.ebean:kotlin-querybean-generator:${Version.ebean}")
    testImplementation("io.ebean:ebean-test:${Version.ebean}")
    testImplementation("com.h2database:h2")
}