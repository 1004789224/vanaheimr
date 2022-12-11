
rootProject.name = "Vanaheimr"
// 适用于project的plugins
pluginManagement {
    repositories {
        mavenLocal()
        if (System.getenv("GITHUB_WORKFLOW") == null) { // 普通环境
            maven(url = "https://mirrors.tencent.com/nexus/repository/maven-public")
            maven(url = "https://mirrors.tencent.com/nexus/repository/gradle-plugins/")
        } else { // GitHub Action 环境
            maven {
                name = "MavenSnapshot"
                url = java.net.URI("https://oss.sonatype.org/content/repositories/snapshots/")
                mavenContent {
                    snapshotsOnly()
                }
            }
            mavenCentral()
            gradlePluginPortal()
        }
    }
}



include(":account")
include(":account:biz")
include(":account:po")
include(":common")
include(":common:common-db")