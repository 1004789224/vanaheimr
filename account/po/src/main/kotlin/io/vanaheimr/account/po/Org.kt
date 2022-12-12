package io.vanaheimr.account.po

import io.ebean.annotation.DbForeignKey
import io.ebean.annotation.Index
import io.vanaheimr.common.db.po.BaseModel
import javax.persistence.*

@Entity
class Org (
    @Index
    var name:String = "",
    @Index
    var parentId:Long = 0,
    @Index
    var status:OrgStatus = OrgStatus.ENABLED,
    @ManyToMany(cascade = [javax.persistence.CascadeType.PERSIST])
    @DbForeignKey(noConstraint=true)

    var accounts:MutableList<Account> = mutableListOf()
    ): BaseModel()