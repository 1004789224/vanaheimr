import contstants.Version
plugins {
    id("db-config")
}
dependencies {


    api(project(":common:common-core"))
    // jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}
