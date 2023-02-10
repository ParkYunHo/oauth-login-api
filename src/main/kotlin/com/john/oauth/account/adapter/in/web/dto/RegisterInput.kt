package com.john.oauth.account.adapter.`in`.web.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

/**
 * @author yoonho
 * @since 2023.02.10
 */
data class RegisterInput (
    @JsonProperty("userId")
    val userId: String,
    @JsonProperty("password")
    val password: String,
    @JsonProperty("nickname")
    val nickName: String,
    @JsonProperty("email")
    val email: String,
    @JsonProperty("birthday")
    val birthday: String,
    @JsonProperty("gender")
    val gender: String,
    @JsonProperty("korName")
    val korName: String,
): Serializable