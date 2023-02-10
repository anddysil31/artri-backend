package com.example.artribackend.config

import com.example.artribackend.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import kotlin.jvm.Throws

@Configuration
class ApplicationConfig {
    @Autowired
    lateinit var repository: MemberRepository

    @Bean
    fun memberDetailService():UserDetailsService?{
        return UserDetailsService { nickname: String? ->
            repository.findByNickname(nickname)
                ?.orElseThrow{UsernameNotFoundException("User Not Found")}
        }
    }
    @Bean
    fun authenticationProvider(): AuthenticationProvider?{
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(memberDetailService())
        authProvider.setPasswordEncoder(passwordEncoder())
        return authProvider
    }

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(config: AuthenticationConfiguration):AuthenticationManager?{
        return config.authenticationManager
    }

    @Bean
    fun passwordEncoder():PasswordEncoder?{
        return BCryptPasswordEncoder()
    }
}