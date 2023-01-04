plugins {
    id("db-conventions")
}
dependencies {
    api(project(":common:common-core"))
    // jackson
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
}
