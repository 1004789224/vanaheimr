plugins {
    id("java-conventions")
}


dependencies {
    // micronaut-security
    compileOnly("io.micronaut:micronaut-http-server-netty")

    // reactor-core
    api("io.projectreactor:reactor-core")
}