import nu.studer.gradle.jooq.JooqGenerate
import org.gradle.configurationcache.extensions.capitalized
import org.jooq.meta.jaxb.ForcedType
import org.jooq.meta.jaxb.Logging

plugins {
    id("java-conventions")
    id("nu.studer.jooq")
    idea

}

val api by configurations
val implementation by configurations
val runtimeOnly by configurations
val jooqVersion by extra { "3.17.6" }

val module = project.parent!!.name.capitalized()
dependencies {
    // postgresql driver
    jooqGenerator("org.postgresql:postgresql:42.5.1")
}

jooq {
    version.set(jooqVersion)
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)

    configurations {
        create("$module") {
            generateSchemaSourceOnCompilation.set(false)
            jooqConfiguration.apply {
                logging = Logging.WARN
                jdbc.apply {
                    // postgresql
                    driver = "org.postgresql.Driver"
                    url = "jdbc:postgresql://localhost:5432/postgres"
                    user = "postgres"
                    password = "postgres"
                }
                generator.apply {

                    name = "org.jooq.codegen.DefaultGenerator"
                    database.apply {
//                        includes = "${module}_*"
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "vanaheimr"
                        forcedTypes.addAll(listOf(
                            ForcedType().apply {
                                isAuditInsertTimestamp = true
                                includeExpression = "create_time"
                            },
                            ForcedType().apply {
                                isAuditUpdateTimestamp = true
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
                        isPojos = true
                        isDaos = false
                        isRecords = false
                        isDeprecated = false
                        isRelations = false
                        isFluentSetters = true
                        isGeneratedAnnotation = false
                        isJavaTimeTypes = true
                    }
                    target.apply {
                        packageName = "io.vanaheimr.${module.decapitalize()}.po"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}
// 使idea能够识别jooq生成的代码
idea {
    module {
        sourceDirs.add(file("${buildDir}/generated-src/jooq/${module}"))
    }
}
sourceSets.getByName("main").java.srcDir("${buildDir}/generated-src/jooq/${module}")
sourceSets.getByName("test").java.srcDir("${buildDir}/generated-src/jooq/${module}")
// 将jooq生成的代码加入到编译中
tasks.getByName("compileJava").dependsOn("generate${module}Jooq")