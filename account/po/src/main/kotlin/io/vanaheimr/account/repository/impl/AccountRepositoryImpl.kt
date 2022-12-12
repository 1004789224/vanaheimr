package io.vanaheimr.account.repository.impl

import io.ebean.PagedList
import io.vanaheimr.account.po.Account
import io.vanaheimr.account.po.AccountStatus
import io.vanaheimr.account.po.query.QAccount
import io.vanaheimr.account.repository.IAccountRepository
import io.vanaheimr.common.db.andIf

class AccountRepositoryImpl : IAccountRepository {
    override fun findAccountByName(name: String): Account? {
        return QAccount().name.like(name).findOne()
    }

    override fun findAccountById(id: Long): Account? {
        return QAccount().id.eq(id).findOne()
    }

    override fun deleteAccountById(id: Long): Boolean {
        return QAccount().id.eq(id).delete() > 0
    }

    override fun updateAccountStatus(id: Long, status: AccountStatus): Boolean {
        return QAccount().id.eq(id).asUpdate().set("status", status).update() > 0
    }

    override fun page(
        page: Int,
        pageSize: Int,
        orgId: Long?,
        status: AccountStatus?,
        roleId: Long?,
        name: String?,
        phone: String?
    ): PagedList<Account> {
        return QAccount()
            .andIf(orgId != null) {
                orgs.id.eq(orgId)
            }
            .andIf(status != null) {
                this.status.eq(status)
            }
            .andIf(roleId != null) {
                roles.id.eq(roleId)
            }
            .andIf(name != null) {
                this.name.like(name)
            }
            .andIf(phone != null) {
                this.phone.like(phone)
            }
            .setFirstRow(page * pageSize)
            .setMaxRows(pageSize)
            .findPagedList()
    }
}