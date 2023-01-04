plugins {
    id("java-conventions")
}


dependencies {
    // micronaut-security
    implementation("io.micronaut:micronaut-http-server-netty")

    // reactor-core
    implementation("io.projectreactor:reactor-core")
    implementation(project(":common:common-core"))
}