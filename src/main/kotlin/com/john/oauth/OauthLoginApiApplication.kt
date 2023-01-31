package com.john.oauth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OauthLoginApiApplication

fun main(args: Array<String>) {
    runApplication<OauthLoginApiApplication>(*args)
}
