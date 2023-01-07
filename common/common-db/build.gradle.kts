plugins {
    id("db-conventions")
}
dependencies {
    // flyway-core
    compileOnly("org.flywaydb:flyway-core")
    api(project(":common:common-core"))
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
}
