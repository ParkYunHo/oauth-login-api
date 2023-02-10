package com.john.oauth.account.adapter.out.persistence

import com.john.oauth.account.adapter.`in`.web.dto.RegisterInput
import com.john.oauth.account.application.port.out.FindPort
import com.john.oauth.account.application.port.out.SavePort
import com.john.oauth.account.domain.Account
import com.john.oauth.common.exception.NotFoundDataException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import java.time.LocalDateTime

/**
 * @author yoonho
 * @since 2023.02.08
 */
@Repository
class AccountPersistenceAdapter(
    private val accountRepository: AccountRepository
): FindPort, SavePort {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun loginProcess(userId: String, password: String): Mono<Boolean> =
        accountRepository.findByUserIdAndPassword(userId, password)
            .switchIfEmpty { throw NotFoundDataException("로그인에 실패하였습니다.") }
            .flatMap { Mono.just(true) }

    override fun register(input: RegisterInput): Mono<Boolean> =
        accountRepository.findByUserId(input.userId)
            .switchIfEmpty {
                accountRepository.save(
                    Account(
                        userId = input.userId,
                        password = input.password,
                        nickName = input.nickName,
                        email = input.email,
                        birthday = input.birthday,
                        gender = input.gender,
                        korName = input.korName,
                        updatedAt = LocalDateTime.now()
                    )
                )
                    .log()
            }
            .log()
            .flatMap { Mono.just(true) }
}