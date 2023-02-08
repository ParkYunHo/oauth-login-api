package com.john.oauth.account.domain

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

/**
 * @author yoonho
 * @since 2023.02.08
 */
@Table(name = "USER_MGMT_TB")
class Account(
    @Column("USER_ID")
    val userId: String,
    @Column("PASSWORD")
    val password: String,
    @Column("NICKNAME")
    val nickName: String,
    @Column("EMAIL")
    val email: String,
    @Column("BIRTHDAY")
    val birthday: String,
    @Column("GENDER")
    val gender: String,
    @Column("KOR_NAME")
    val korName: String,
    @Column("UPDATED_AT")
    val updatedAt: LocalDateTime,
    @Column("CREATED_AT")
    val createdAt: LocalDateTime = LocalDateTime.now(),
)