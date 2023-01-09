package io.vanaheimr.common.web

import io.micronaut.core.order.Ordered
import io.micronaut.http.HttpRequest
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.HttpServerFilter
import io.micronaut.http.filter.ServerFilterChain
import io.vanaheimr.common.core.RequestContext
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactor.mono
import org.reactivestreams.Publisher

@Filter("/**")
class RequestContextFilter : HttpServerFilter {

    override fun getOrder() = Ordered.HIGHEST_PRECEDENCE

    override fun doFilter(request: HttpRequest<*>, chain: ServerFilterChain): Publisher<MutableHttpResponse<*>> {
        return mono(RequestContext()) {
            chain.proceed(request).awaitFirstOrNull()
        }
    }
}