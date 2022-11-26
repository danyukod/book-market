package com.mercadolivro.config

import com.mercadolivro.repository.CustomerRepository
import com.mercadolivro.security.AuthenticationFilter
import com.mercadolivro.service.UserDetailsCustomService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val configuration: AuthenticationConfiguration,
    private val customerRepository: CustomerRepository,
    private val userDetails: UserDetailsCustomService
) {

    private val PUBLIC_MATCHERS = arrayOf<String>()

    private val PUBLIC_POST_MATCHERS = arrayOf(
        "/customers"
    )

    @Bean
    fun authProvider(auth: AuthenticationManagerBuilder): DaoAuthenticationProvider{
        val authProvider = DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetails)
        authProvider.setPasswordEncoder(bCryptPasswordEncoder())
        return authProvider
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.cors().and().csrf().disable()
        http.authorizeRequests()
            .antMatchers(*PUBLIC_MATCHERS).permitAll()
            .antMatchers(HttpMethod.POST, *PUBLIC_POST_MATCHERS).permitAll()
            .anyRequest().authenticated()
        http.addFilter(AuthenticationFilter(configuration.authenticationManager, customerRepository))
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        return http.build()
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

}