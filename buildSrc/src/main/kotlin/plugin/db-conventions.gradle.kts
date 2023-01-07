import contstants.Version

plugins {
    id("java-conventions")
}





dependencies {

    runtimeOnly("org.postgresql:r2dbc-postgresql")
    implementation("io.micronaut.r2dbc:micronaut-r2dbc-core")
    api("io.micronaut.sql:micronaut-jooq")
}