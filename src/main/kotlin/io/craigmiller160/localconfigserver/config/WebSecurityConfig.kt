package io.craigmiller160.localconfigserver.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories

@Configuration
@EnableWebSecurity
class WebSecurityConfig (
        @Value("\${spring.cloud.config.server.security.username}") private val userName: String,
        @Value("\${spring.cloud.config.server.security.password}") private val password: String
) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.let {
            val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
            auth.inMemoryAuthentication()
                    .withUser(userName)
                    .password(password)
                    .roles(SecurityConstants.DEFAULT_ROLE)
                    .and()
                    .passwordEncoder(encoder)
        }
    }

    override fun configure(http: HttpSecurity?) {
        http?.let {
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/actuator/**").permitAll()
                    .antMatchers("/**").hasRole(SecurityConstants.DEFAULT_ROLE)
                    .and()
                    .httpBasic()
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }
    }
}