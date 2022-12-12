plugins {
    id("copy-profiles")

    id("db-config")
}
dependencies {
    implementation(project(":common:common-db"))

}