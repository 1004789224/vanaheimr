package io.vanaheimr.common.db.provider

import io.ebean.config.CurrentTenantProvider
import io.ebean.config.CurrentUserProvider
import io.vanaheimr.common.core.RequestContext

class RequestContextUserProvider : CurrentUserProvider, CurrentTenantProvider {
    override fun currentUser() = RequestContext.get().userId
    override fun currentId() = RequestContext.get().tenantId
}