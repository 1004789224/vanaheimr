allprojects {
    repositories {
        mavenLocal()
        maven(url = "https://mirrors.tencent.com/nexus/repository/maven-public")
        maven(url = "https://mirrors.tencent.com/nexus/repository/gradle-plugins/")
        mavenCentral()
    }
}