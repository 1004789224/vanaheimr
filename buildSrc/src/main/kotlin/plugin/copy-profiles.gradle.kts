

apply(plugin="idea")

// 将根目录下的common-profiles拷贝到boot项目中的resources目录下
// Copy common-profiles from root directory to resources directory in boot project
copy {
    from("common-profiles")
    into("src/main/resources")
}
copy {
    from("common-profiles")
    into("src/test/resources")
}

