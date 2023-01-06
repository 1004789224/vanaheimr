import org.jooq.meta.jaxb.ForcedType
import org.jooq.meta.jaxb.Logging

plugins {
    id("nu.studer.jooq")
}

val api by configurations
val implementation by configurations
val runtimeOnly by configurations
val jooqGroup by extra { "org.jooq.trial-java-8" }
val jooqVersion by extra { "3.17.3" }

val module = project.project.name
dependencies {
    api("$jooqGroup:jooq:$jooqVersion")
    implementation("$jooqGroup:jooq-codegen:$jooqVersion")
    implementation("$jooqGroup:jooq-meta:$jooqVersion")
    jooqGenerator("mysql:mysql-connector-java")
    runtimeOnly("mysql:mysql-connector-java")
}

jooq {
    version.set(jooqVersion)
    edition.set(nu.studer.gradle.jooq.JooqEdition.TRIAL_JAVA_8)

    configurations {
        create("poc") {
            generateSchemaSourceOnCompilation.set(false)
            jooqConfiguration.apply {
                logging = Logging.WARN
                jdbc.apply {
                    driver = "org.postgresql.Driver"
                    url = "jdbc:postgresql://localhost:5432/mydemo"
                    user = "foo"
                    password = "bar"
                }
                generator.apply {

                    name = "org.jooq.codegen.DefaultGenerator"
                    database.apply {
                        includes = "${module}_*"
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "public"
                        forcedTypes.addAll(listOf(
                            ForcedType().apply {
                                isAuditInsertTimestamp = true
                                name = "int"
                                includeExpression = "create_time"
                            },
                            ForcedType().apply {
                                isAuditUpdateTimestamp = true
                                name = "timestamptz"
                                includeExpression = "update_time"
                            },
                            ForcedType().apply {
                                isAuditInsertUser = true
                                name = "bigint"
                                includeExpression = "create_by"
                            },
                            ForcedType().apply {
                                isAuditUpdateUser = true
                                name = "bigint"
                                includeExpression = "update_by"
                            }

                        ))
                    }
                    generate.apply {
                        isPojos = false
                        isDaos = false
                        isRecords = true
                        isDeprecated = false
                    }
                    target.apply {
                        packageName = "io.vanaheimr.${module}.po"
                        directory = "src/main/java"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}