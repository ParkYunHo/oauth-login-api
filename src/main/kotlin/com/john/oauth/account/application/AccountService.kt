package com.john.oauth.account.application

import com.john.oauth.account.application.port.`in`.LoginUseCase
import com.john.oauth.account.application.port.out.LoginPort
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2023.02.08
 */
@Service
class AccountService(
    private val loginPort: LoginPort
): LoginUseCase {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun loginProcess(userId: String, password: String): Mono<Boolean> =
        loginPort.loginProcess(userId, password)
}