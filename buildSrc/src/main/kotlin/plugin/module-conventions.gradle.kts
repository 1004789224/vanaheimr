import gradle.kotlin.dsl.accessors._b4ea55e49131caed5ed9fe789b9cef1e.api

val module = project.name
subprojects {

    when (this.project.name) {
        "api" -> {
            apply(plugin = "api-conventions")

        }

        "biz" -> {
            apply(plugin = "lib-conventions")
            val implementation by this.configurations
            val api by this.configurations
            dependencies {
                api(project(":$module:api"))
                implementation(project(":$module:po"))
            }
        }

        "po" -> {
            apply(plugin = "db-conventions")
            apply(plugin = "java-conventions")
            val implementation by this.configurations
            dependencies {
                implementation(project(":common:common-db"))

            }
        }

        "boot" -> {
            apply(plugin = "boot-conventions")
            val implementation by this.configurations
            dependencies {
                implementation(project(":$module:biz"))
            }
        }

    }
    val implementation by this.configurations
    this.dependencies {
        implementation(project(":common:common-core"))
    }
}