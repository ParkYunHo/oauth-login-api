package com.john.oauth.account.application.port.`in`

import com.john.oauth.account.adapter.`in`.web.dto.RegisterInput
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2023.02.08
 */
interface RegisterUseCase {
    fun register(input: RegisterInput): Mono<Boolean>
}