subprojects {

    when (this.project.name) {
        "api" -> {
            apply(plugin = "api-conventions")
        }

        "biz" -> {
            apply(plugin = "lib-conventions")

        }

        "po" -> {
            apply(plugin = "db-conventions")
        }
    }
    val implementation by this.configurations
    this.dependencies {
        implementation(project(":common:common-core"))
    }
}