package io.vanaheimr.account.po

import io.ebean.annotation.DbForeignKey
import io.ebean.annotation.DbJson
import io.ebean.annotation.Index
import io.vanaheimr.common.db.po.BaseModel
import javax.persistence.Entity
import javax.persistence.ManyToMany

@Entity
class Role(
    @Index
    val name:String,
    val desc:String,
    @DbJson
    val metadata:MutableMap<String,Any>,
    @ManyToMany(cascade = [javax.persistence.CascadeType.PERSIST])
    @DbForeignKey(noConstraint=true)
    val permissions:MutableList<Permission> = mutableListOf()
): BaseModel()