package com.john.oauth.account.adapter.out.persistence

import com.john.oauth.account.domain.Account
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2023.02.08
 */
interface AccountRepository: ReactiveCrudRepository<Account, String> {
    fun findByUserIdAndPassword(userId: String, password: String): Mono<Account>
}