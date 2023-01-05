package io.vanaheimr.account.po

import io.micronaut.data.annotation.Index
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation
import io.micronaut.data.annotation.TypeDef
import io.micronaut.data.model.DataType
import io.vanaheimr.common.db.po.BaseEntity

@MappedEntity
class Permission(
    @Index(name = "permission_name", columns = ["name"])
    val name: String,
    val desc: String,
    @TypeDef(type = DataType.JSON)
    val metadata: MutableMap<String, Any>,
    @Relation(
        value = Relation.Kind.MANY_TO_MANY,
        mappedBy = "permissions",
    )
    val roles: MutableList<Role> = mutableListOf()
) : BaseEntity()