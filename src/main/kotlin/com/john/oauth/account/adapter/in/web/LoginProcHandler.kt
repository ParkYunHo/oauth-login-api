package com.john.oauth.account.adapter.`in`.web

import com.john.oauth.account.adapter.`in`.web.dto.LoginInput
import com.john.oauth.account.adapter.`in`.web.dto.RegisterInput
import com.john.oauth.account.application.port.`in`.LoginUseCase
import com.john.oauth.account.application.port.`in`.RegisterUseCase
import com.john.oauth.common.dto.BaseResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2023.02.10
 */
@Component
class LoginProcHandler(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun auth(request: ServerRequest): Mono<ServerResponse> =
        request.bodyToMono(LoginInput::class.java)
            .log()
            .flatMap { loginUseCase.loginProcess(it.userId, it.password) }
            .flatMap { BaseResponse().success(it) }

    fun register(request: ServerRequest): Mono<ServerResponse> =
        request.bodyToMono(RegisterInput::class.java)
            .log()
            .flatMap { registerUseCase.register(it) }
            .flatMap { BaseResponse().success(it) }
}