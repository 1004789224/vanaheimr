package io.vanaheimr.common.db.provider

import io.ebean.config.CurrentUserProvider
import io.vanaheimr.common.core.RequestContext

class RequestContextUserProvider: CurrentUserProvider {
    override fun currentUser()= RequestContext.get().userId
}