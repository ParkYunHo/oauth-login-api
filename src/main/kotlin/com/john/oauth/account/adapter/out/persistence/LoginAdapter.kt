package com.john.oauth.account.adapter.out.persistence

import com.john.oauth.account.application.port.out.LoginPort
import com.john.oauth.common.exception.NotFoundDataException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

/**
 * @author yoonho
 * @since 2023.02.08
 */
@Repository
class LoginAdapter(
    private val accountRepository: AccountRepository
): LoginPort {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun loginProcess(userId: String, password: String): Mono<Boolean> =
        accountRepository.findByUserIdAndPassword(userId, password)
            .switchIfEmpty { throw NotFoundDataException("로그인에 실패하였습니다.") }
            .flatMap { Mono.just(true) }
}