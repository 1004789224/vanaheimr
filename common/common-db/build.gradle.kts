plugins {
    id("db-conventions")
}
dependencies {
    api(project(":common:common-core"))
    // jackson
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
// https://mvnrepository.com/artifact/jakarta.persistence/jakarta.persistence-api
    api("jakarta.persistence:jakarta.persistence-api:3.1.0")
    // query dsl
    api("com.querydsl:querydsl-jpa:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")

//// https://mvnrepository.com/artifact/javax.persistence/javax.persistence-api
//    runtimeOnly("javax.persistence:javax.persistence-api:2.2")
//

}
