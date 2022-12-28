package io.vanaheimr.account.po

import io.ebean.annotation.DbForeignKey
import io.ebean.annotation.Index
import io.vanaheimr.common.db.po.BaseModel
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.ManyToMany

@Entity
class Account(
    var name: String,
    var password: String,
    var phone: String,
    @ManyToMany(cascade = [CascadeType.PERSIST])
    @DbForeignKey(noConstraint = true)
    val roles: MutableList<Role> = mutableListOf(),
    @DbForeignKey(noConstraint = true)
    @ManyToMany(cascade = [CascadeType.PERSIST])
    val orgs: MutableList<Org> = mutableListOf(),
    @Index
    var status: AccountStatus = AccountStatus.ENABLED,
    var email: String? = null,
    var address: String? = null,
    var avatar: String? = null,
) : BaseModel()