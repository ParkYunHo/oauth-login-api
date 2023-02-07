package com.john.oauth.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer

/**
 * @author yoonho
 * @since 2023.02.07
 */
@EnableWebFlux
@Configuration
class WebFluxConfig: WebFluxConfigurer {
}