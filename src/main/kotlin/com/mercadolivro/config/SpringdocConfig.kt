package com.mercadolivro.config

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class SpringdocConfig {

    @Bean
    fun api(): OpenAPI = OpenAPI().info(
        Info().title("Mercado Livro")
            .description("Aplicacao Mercado Livro")
            .version("v0.0.1")
            .license(License().name("Mercado Livro").url("http://mercadolivro.com.br")))
        .externalDocs(ExternalDocumentation().description("Mercado Livro Documentation").url(
            "http://mercadolivro.wiki.github.org/docs"
        ))

}