package io.vanaheimr.common.web;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.filter.FilterChain;
import io.micronaut.http.filter.HttpFilter;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

@Singleton
public class RequestContextFilter implements HttpFilter {
    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(HttpRequest<?> request, FilterChain chain) {
        return chain.proceed(request);
    }
}
