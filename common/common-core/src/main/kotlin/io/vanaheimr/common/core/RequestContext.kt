package io.vanaheimr.common.core

import io.micronaut.http.HttpRequest
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/**
 * A class that holds the current request context.
 */
class RequestContext(private val map: MutableMap<String, Any> = HashMap(56)) : MutableMap<String, Any> by map,
    AbstractCoroutineContextElement(RequestContext) {
    var userId: Long by this

    var userName: String by this

    var roleIds: List<Long> by this

    var permissionIds: List<Long> by this

    var request: HttpRequest<*> by this

    // 租户id
    var tenantId: Long by this

    companion object : CoroutineContext.Key<RequestContext>
}
