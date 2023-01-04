package io.vanaheimr.account.api

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get


@Controller("/test")
class TestController {


    @Get("/hello")
    fun hello(): String {
        println("dsada")
        return "hello"
    }

    @Get("/auth-needed")
    fun withAuth(): String {
        return "hello"
    }

    @Get("/auth-unneeded")
    fun withoutAuth(): String {
        return "hello"
    }

    @Get("/permission-needed")
    fun withpermission(): String {
        return "hello"
    }
}