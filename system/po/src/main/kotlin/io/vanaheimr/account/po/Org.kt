package io.vanaheimr.account.po

import io.vanaheimr.common.db.po.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.ManyToMany

@Entity
class Org(
    @param:Index(name = "org_name", columnList = "name")
    var name: String = "",
    @Index(name = "org_parentId", columns = ["parentId"])
    var parentId: Long = 0,

    @Index(name = "org_path", columns = ["path"])
    var path: String = "",
    @Index(name = "org_status", columns = ["status"])
    var status: OrgStatus = OrgStatus.ENABLED,
    @ManyToMany
    var accounts: MutableList<Account> = mutableListOf()
) : BaseEntity()