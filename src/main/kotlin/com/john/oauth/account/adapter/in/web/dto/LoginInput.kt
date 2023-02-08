package com.john.oauth.account.adapter.`in`.web.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

/**
 * @author yoonho
 * @since 2023.02.08
 */
data class LoginInput (
    @JsonProperty("userId")
    val userId: String,
    @JsonProperty("password")
    val password: String
): Serializable