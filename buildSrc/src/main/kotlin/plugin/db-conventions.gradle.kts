import contstants.Version

plugins {
    id("java-conventions")
}




dependencies {
    // javax-persistence-api
    kapt("io.micronaut.data:micronaut-data-processor")
    implementation("io.micronaut.data:micronaut-data-r2dbc")
    implementation("io.micronaut.flyway:micronaut-flyway")
    testImplementation("com.h2database:h2")
    runtimeOnly("org.postgresql:r2dbc-postgresql")
}