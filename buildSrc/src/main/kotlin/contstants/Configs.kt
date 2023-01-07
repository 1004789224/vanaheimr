package contstants

import org.gradle.api.Project
import org.jooq.meta.jaxb.Jdbc
import java.io.File

object Configs {

    fun Project.jooqJdbcConfig(): Jdbc.() -> Unit = {
        driver = "org.h2.Driver"
        url = "jdbc:h2:file:${File(project.rootProject.rootDir, "vanaheimr").path};AUTO_SERVER=TRUE"
        user = "sa"
        password = ""
    }
}