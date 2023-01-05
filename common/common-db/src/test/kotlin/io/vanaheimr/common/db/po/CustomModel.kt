package io.vanaheimr.common.db.po

import io.micronaut.data.annotation.MappedEntity


@MappedEntity
open class CustomModel(name: String) : BaseEntity() {
    val name: String = name
    override fun toString(): String {
        return "CustomModel(name='$name')"
    }

}