package io.craigmiller160.localconfigserver.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.let {
            val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
            auth.inMemoryAuthentication()
                    .withUser("config-server-user")
                    .password("{bcrypt}\$2a\$10\$lz.0VwmpdubNVy4quE57FOk3FYTcB6GGSyKCA9RG0Xaj00ojJ5QXW")
                    .roles(SecurityConstants.DEFAULT_ROLE)
                    .and()
                    .passwordEncoder(encoder)
        }
    }

    override fun configure(http: HttpSecurity?) {
        http?.let {
            http.csrf().disable()
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .anyRequest().hasRole(SecurityConstants.DEFAULT_ROLE)
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }
    }
}