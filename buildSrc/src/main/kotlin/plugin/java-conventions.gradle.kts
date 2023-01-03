
plugins {
    `java-library`
    kotlin("jvm")
    id("org.jetbrains.kotlin.kapt")
}
repositories {
    mavenLocal()

    // tencent
    maven {
        url = uri("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/")
    }
    mavenCentral()
}
group = "io.vanaheimr"
version = "1.0.0-alpha"
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}


dependencies {
    implementation(platform("io.micronaut:micronaut-bom:3.1.0"))
    kapt("io.micronaut:micronaut-inject-java")
    kaptTest("io.micronaut:micronaut-inject-java")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("io.micronaut.test:micronaut-test-junit5")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("io.micronaut.test:micronaut-test-rest-assured")
}


tasks.withType<Test> {
    useJUnitPlatform()
}