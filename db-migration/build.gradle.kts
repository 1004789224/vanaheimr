plugins {
    id("java-conventions")
    id("org.flywaydb.flyway")
}


flyway {
    url = "jdbc:postgresql://localhost:5432/postgres"
    user = "postgres"
    password = "postgres"
    schemas = arrayOf("vanaheimr")
    locations = arrayOf("classpath:db/migration")
    cleanDisabled = false
}

//flyway dependOn build
tasks.getByName("flywayMigrate").dependsOn("compileKotlin")


dependencies {
    implementation("org.flywaydb:flyway-core")
    // postgresql driver
    implementation("org.postgresql:postgresql")
    implementation(project(":common:common-db"))
    implementation("org.jooq:jooq")

}