package io.vanaheimr.common.db.provider

import io.ebean.config.CurrentTenantProvider
import io.ebean.config.CurrentUserProvider

@Suppress("unused")
class RequestContextUserProvider : CurrentUserProvider, CurrentTenantProvider {
    override fun currentUser() = 1
    override fun currentId() = 1
}