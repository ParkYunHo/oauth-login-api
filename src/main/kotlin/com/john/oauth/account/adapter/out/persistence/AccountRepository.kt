package com.john.oauth.account.adapter.out.persistence

import com.john.oauth.account.domain.Account
import org.springframework.data.repository.reactive.ReactiveCrudRepository

/**
 * @author yoonho
 * @since 2023.02.08
 */
interface AccountRepository: ReactiveCrudRepository<Account, String> {
}