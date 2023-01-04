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