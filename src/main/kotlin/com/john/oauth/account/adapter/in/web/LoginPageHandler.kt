package com.john.oauth.account.adapter.`in`.web

import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2023.02.10
 */
@Component
class LoginPageHandler {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun loginPage(request: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("/login/login")

    fun registerPage(request: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("/login/register")
}