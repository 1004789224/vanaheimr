package io.vanaheimr.common.db.po

import javax.persistence.Entity

@Entity
open class CustomModel(name: String) : BaseModel() {
    val name: String = name
    override fun toString(): String {
        return "CustomModel(name='$name')"
    }

}