

plugins {
    id("java-conventions")
    id("io.micronaut.application")
    kotlin("jvm")
}

graalvmNative {
    binaries {
        named("main") {
            imageName.set(project.parent!!.name + "-" + project.name)
            buildArgs.add("--verbose")

            javaLauncher.set(javaToolchains.launcherFor {
                languageVersion.set(JavaLanguageVersion.of(17))
                vendor.set(JvmVendorSpec.matching("GraalVM Community"))
            })
            sharedLibrary.set(false)
        }
    }
}
dependencies {
    // micronaut-runtime
    implementation("io.micronaut:micronaut-runtime")
    runtimeOnly("ch.qos.logback:logback-classic")
    compileOnly("org.graalvm.nativeimage:svm")
}

micronaut {
    version.set("3.8.0")
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations.add("io.vanaheimr.*")
    }
}