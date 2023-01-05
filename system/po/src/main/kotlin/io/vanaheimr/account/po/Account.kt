package io.vanaheimr.account.po

import io.micronaut.data.annotation.Index
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation
import io.vanaheimr.common.db.po.BaseEntity
import jakarta.persistence.ManyToMany


@MappedEntity
class Account(

    @Index(name = "account_name", columns = ["name"])
    var name: String,
    var password: String,
    @Index(name = "account_phone", columns = ["phone"])
    var phone: String,
    @Relation(
        value = Relation.Kind.MANY_TO_MANY,
        mappedBy = "account",
    )
    val roles: MutableList<Role> = mutableListOf(),
    @ManyToMany
    val orgs: MutableList<Org> = mutableListOf(),
    @Index(name = "account_status", columns = ["status"])
    var status: AccountStatus = AccountStatus.ENABLED,
    var email: String? = null,
    var address: String? = null,
    var avatar: String? = null,
) : BaseEntity()