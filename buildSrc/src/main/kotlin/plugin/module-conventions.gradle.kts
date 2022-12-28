


subprojects{
    when(this.project.name){
        "api"->{
            apply(plugin = "api-conventions")
        }
        "biz"->{
            apply(plugin = "lib-conventions")

        }
        "po"->{
            apply(plugin = "db-conventions")
        }
    }
}