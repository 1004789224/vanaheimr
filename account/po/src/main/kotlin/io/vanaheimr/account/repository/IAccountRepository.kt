package io.vanaheimr.account.repository

import io.ebean.PagedList
import io.vanaheimr.account.po.Account
import io.vanaheimr.account.po.AccountStatus

interface IAccountRepository {
    fun findAccountByName(name: String): Account?
    fun findAccountById(id: Long): Account?

    fun deleteAccountById(id: Long): Boolean

    fun updateAccountStatus(id: Long, status: AccountStatus): Boolean

    fun page(
        page: Int, pageSize: Int,
        orgId: Long? = null,
        status: AccountStatus? = null,
        roleId: Long? = null,
        name: String? = null,
        phone: String? = null,
    ): PagedList<Account>
}