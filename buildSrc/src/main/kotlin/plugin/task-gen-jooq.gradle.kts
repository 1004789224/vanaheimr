import nu.studer.gradle.jooq.JooqGenerate
import org.gradle.api.tasks.compile.AbstractCompile
import org.jooq.meta.jaxb.ForcedType

plugins {
    id("nu.studer.jooq")
}

val jooqGenerator by configurations
val api by configurations

dependencies {
    jooqGenerator("mysql:mysql-connector-java:8.0.28")
    api("org.jooq:jooq")
}

// 1.读取当前项目的table_includes、 table_excludes

val tableIncludes: String by project
val tableExcludes: String by project


val mysqlURL: String by project
val mysqlUser: String by project
val mysqlPasswd: String by project
val databaseName: String by project

val moduleName = project.name.split("-")[1]

jooq {
    configurations {
        create("jooqGenerator") {
            jooqConfiguration.apply {
                jdbc.apply {
                    driver = "com.mysql.cj.jdbc.Driver"
                    url = "jdbc:mysql://$mysqlURL/$databaseName?useSSL=false"
                    user = mysqlUser
                    password = mysqlPasswd
                }
                generator.apply {
                    generator.apply {
                        name = "org.jooq.codegen.DefaultGenerator"
                        database.apply {
                            name = "org.jooq.meta.mysql.MySQLDatabase"
                            inputSchema = databaseName
                            includes = tableIncludes
                            excludes = tableExcludes
                            withIncludeRoutines(false) // 兼容"denied to user for table 'proc'"错误
                            // 生成create_at、update_at、create_by、update_by字段的audit ForcedType列
                            withForcedTypes(
                                ForcedType().withAuditInsertTimestamp(true).withExpression("create_at"),
                                ForcedType().withAuditInsertUser(true).withExpression("create_by"),
                                ForcedType().withAuditUpdateTimestamp(true).withExpression("update_at"),
                                ForcedType().withAuditUpdateUser(true).withExpression("update_by"),
                            )
                        }


                        strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"

                        generate.apply {
                            isRecords = true
                            isImmutablePojos = true
                            isRelations = false
                            isDeprecated = false
                            isFluentSetters = true
                            isGeneratedAnnotation = false
                            isJavaTimeTypes = true

                        }

                        target.apply {
                            packageName = "io.nanfeng.vanaheimr.$moduleName"
                        }
                    }
                }
            }


        }


    }
}