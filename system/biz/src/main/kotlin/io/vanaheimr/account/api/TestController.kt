package io.vanaheimr.account.api

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get


@Controller("/test")
class TestController {


    @Get("/hello")
    fun hello(): String {
        return "hello"
    }
}