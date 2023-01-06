import contstants.Version
import gradle.kotlin.dsl.accessors._b4ea55e49131caed5ed9fe789b9cef1e.api

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
tasks.getByName("flywayMigrate").dependsOn("build")

dependencies {
    implementation("org.flywaydb:flyway-core")
    // jooq
    implementation("org.jooq:jooq")
    // javax-persistence-api
    kapt("io.micronaut.data:micronaut-data-processor")
    implementation("io.micronaut.data:micronaut-data-r2dbc")
    testImplementation("com.h2database:h2")
    runtimeOnly("org.postgresql:r2dbc-postgresql")
}