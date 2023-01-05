plugins {
    id("db-conventions")
}
dependencies {
    api(project(":common:common-core"))
    // jackson
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
// https://mvnrepository.com/artifact/jakarta.persistence/jakarta.persistence-api
    api("jakarta.persistence:jakarta.persistence-api:3.1.0")


}
