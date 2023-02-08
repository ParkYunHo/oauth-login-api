package com.john.oauth.account.adapter.`in`.web

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

/**
 * @author yoonho
 * @since 2023.02.08
 */
@Configuration
class AccountRouter(
    private val accountHandler: AccountHandler
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun loginPageRouterFunction(): RouterFunction<ServerResponse> =
        router {
            accept(MediaType.APPLICATION_JSON).nest {
                GET("/login", accountHandler::loginPage)
                GET("/login/find", accountHandler::findAccountPage)
                GET("/login/register", accountHandler::registerPage)
            }
        }

    @Bean
    fun loginProcessRouterFunction(): RouterFunction<ServerResponse> =
        router {
            accept(MediaType.APPLICATION_JSON).nest {
                POST("/api/login/auth", accountHandler::loginAuth)
            }
        }
}