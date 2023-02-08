package com.john.oauth.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpMethod
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.ViewResolverRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.RouterFunction
import org.thymeleaf.spring6.ISpringWebFluxTemplateEngine
import org.thymeleaf.spring6.SpringWebFluxTemplateEngine
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.spring6.view.reactive.ThymeleafReactiveViewResolver
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ITemplateResolver
import org.springframework.web.reactive.function.server.RouterFunctions.resources
import org.springframework.web.reactive.function.server.ServerResponse

/**
 * @author yoonho
 * @since 2023.02.07
 */
@EnableWebFlux
@Configuration
class WebFluxConfig: WebFluxConfigurer {

    @Bean
    fun resourceRouter(): RouterFunction<ServerResponse> =
        resources("/**", ClassPathResource("static/"))

    @Bean
    fun templateResolver(): ITemplateResolver {
        val resolver = SpringResourceTemplateResolver()
        resolver.prefix = "classpath:templates/"
        resolver.suffix = ".html"
        resolver.templateMode = TemplateMode.HTML
        resolver.isCacheable = false
        resolver.checkExistence = false

        return resolver
    }

    @Bean
    fun templateEngine(): ISpringWebFluxTemplateEngine {
        val engine = SpringWebFluxTemplateEngine()
        engine.setTemplateResolver(templateResolver())
        return engine
    }

    @Bean
    fun reactiveViewResolver(): ThymeleafReactiveViewResolver {
        val viewResolver = ThymeleafReactiveViewResolver()
        viewResolver.templateEngine = templateEngine()
        return viewResolver
    }

    override fun configureViewResolvers(registry: ViewResolverRegistry) {
        registry.viewResolver(reactiveViewResolver())
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry
            .addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name())
            .allowedHeaders("*")
            .maxAge(3000)
    }
}