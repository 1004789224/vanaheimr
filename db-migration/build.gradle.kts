plugins {
    id("java-conventions")
    id("org.flywaydb.flyway")
}


flyway {
    url = "jdbc:h2:file:${File(project.rootProject.rootDir, "vanaheimr").path};AUTO_SERVER=TRUE"
    user = "sa"
    password = ""
    schemas = arrayOf("vanaheimr")
    locations = arrayOf("classpath:db/migration")
    cleanDisabled = false
}

//flyway dependOn build
tasks.getByName("flywayMigrate").dependsOn("compileKotlin")


dependencies {
    implementation("org.flywaydb:flyway-core")

    implementation(project(":common:common-db"))
    testImplementation("com.h2database:h2")
    implementation("org.jooq:jooq")

}