package com.john.oauth.account.adapter.`in`.web

import com.john.oauth.account.adapter.`in`.web.dto.LoginInput
import com.john.oauth.account.application.port.`in`.LoginUseCase
import com.john.oauth.common.dto.BaseResponse
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2023.02.08
 */
@Component
class AccountHandler(
    private val loginUseCase: LoginUseCase
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun loginPage(request: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("/login/login")

    fun findAccountPage(request: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("/login/findAccount")

    fun registerPage(request: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("/login/register")


    fun loginAuth(request: ServerRequest): Mono<ServerResponse> =
        request.bodyToMono(LoginInput::class.java)
            .log()
            .flatMap { loginUseCase.loginProcess(it.userId, it.password) }
            .flatMap { BaseResponse().success(it) }
}