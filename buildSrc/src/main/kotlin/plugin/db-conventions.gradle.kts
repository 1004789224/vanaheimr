import contstants.Version

plugins {
    id("java-conventions")
    // ebean
    id("io.ebean")
}




dependencies {
    runtimeOnly("mysql:mysql-connector-java")
    implementation("io.ebean:ebean:${Version.ebean}")
    kapt("io.ebean:kotlin-querybean-generator:${Version.ebean}")
    testImplementation("io.ebean:ebean-test:${Version.ebean}")
    testImplementation("com.h2database:h2")

}