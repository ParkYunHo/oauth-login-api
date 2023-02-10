package com.john.oauth.account.application.port.out

import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2023.02.08
 */
interface FindPort {
    fun loginProcess(userId: String, password: String): Mono<Boolean>
}