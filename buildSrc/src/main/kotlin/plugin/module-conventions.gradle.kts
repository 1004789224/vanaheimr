val moduleName = project.name
subprojects {
    when (this.project.name) {
        "api" -> {
            apply(plugin = "api-conventions")
            val implementation by this.configurations
            val api by this.configurations
            dependencies {
                api(project(":common:common-core"))
            }
        }

        "biz" -> {
            apply(plugin = "lib-conventions")
            apply(plugin = "db-conventions")
            val implementation by this.configurations
            dependencies {
                implementation(project(":common:common-db"))
                implementation(project(":$moduleName:api"))
                implementation("org.springframework.boot:spring-boot-starter-web")
            }
        }

        "boot" -> {
            apply(plugin = "boot-conventions")
            val implementation by this.configurations
            dependencies {
                implementation(project(":$moduleName:biz"))
            }
        }

    }
}