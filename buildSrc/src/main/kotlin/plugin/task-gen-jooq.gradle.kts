import org.jooq.meta.jaxb.ForcedType
import org.jooq.meta.jaxb.Logging

plugins {
    id("nu.studer.jooq")
}

val api by configurations
val implementation by configurations
val runtimeOnly by configurations
val jooqGroup by extra{"org.jooq.trial-java-8"}
val jooqVersion by extra{"3.17.3"}

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
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "public"
                        forcedTypes.addAll(listOf(
                            ForcedType().apply {
                                name = "varchar"
                                includeExpression = ".*"
                                includeTypes = "JSONB?"
                            },
                            ForcedType().apply {
                                name = "varchar"
                                includeExpression = ".*"
                                includeTypes = "INET"
                            },
                            ForcedType().apply {
//                                auditUpdateUser = true
                                name = "int"
                                includeExpression = "last_modifier"
                            },
                            ForcedType().apply {
//                                auditUpdateTimestamp = true
                                name = "timestamptz"
                                includeExpression = "last_modified"
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
                        packageName = "my.app.jooq"
                        directory = "src/main/java"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}