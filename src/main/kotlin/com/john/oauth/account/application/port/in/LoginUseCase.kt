package com.john.oauth.account.application.port.`in`

import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2023.02.08
 */
interface LoginUseCase {
    fun loginProcess(userId: String, password: String): Mono<Boolean>
}