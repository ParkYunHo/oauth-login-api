package com.john.oauth.account.application

import com.john.oauth.account.adapter.`in`.web.dto.RegisterInput
import com.john.oauth.account.application.port.`in`.LoginUseCase
import com.john.oauth.account.application.port.`in`.RegisterUseCase
import com.john.oauth.account.application.port.out.FindPort
import com.john.oauth.account.application.port.out.SavePort
import com.john.oauth.common.utils.CipherUtil
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2023.02.08
 */
@Service
class AccountService(
    private val findPort: FindPort,
    private val savePort: SavePort
): LoginUseCase, RegisterUseCase {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun loginProcess(userId: String, password: String): Mono<Boolean> =
        findPort.loginProcess(userId, CipherUtil.encode(password))

    override fun register(input: RegisterInput): Mono<Boolean> =
        Mono.just(input)
            .map { it.password = CipherUtil.encode(input.password) }
            .flatMap { savePort.register(input) }
}