plugins {
    id("db-conventions")
}
dependencies {


    api(project(":common:common-core"))
    // jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}
