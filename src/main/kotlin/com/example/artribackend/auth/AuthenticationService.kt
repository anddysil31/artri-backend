package com.example.artribackend.auth

import com.example.artribackend.config.JwtService
import com.example.artribackend.model.Member
import com.example.artribackend.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticationService {
    @Autowired
    lateinit var repository: MemberRepository
    //    private val repository: UserRepository? = null
    @Autowired
    private val passwordEncoder: PasswordEncoder? = null
    @Autowired
    lateinit var jwtService: JwtService
    //private val jwtService: JwtService? = null
    @Autowired
    lateinit var authenticationManager: AuthenticationManager
    //private val authenticationManager: AuthenticationManager? = null

    fun register(request: RegisterRequest): AuthenticationResponse? {
        val member= Member().apply {
            nickname = request.nickname
            name= request.name
            lastname=request.lastname
            age = request.age
            email = request.email
            passwordMember= passwordEncoder?.encode(request.password)
            role= request.role

        }

        repository?.save(member)
        val jwtToken = jwtService?.generateToken(member)
        return AuthenticationResponse().apply {
            token=jwtToken
        }

    }

    fun authenticate(request: AuthenticationRequest): AuthenticationResponse? {
        authenticationManager!!.authenticate(
            UsernamePasswordAuthenticationToken(
                request.email,
                request.password
            )
        )
        val user = repository?.findByEmail(request.email)?.orElseThrow()
        var idMember = repository?.findIdByEmail(request.email)?.id
        var memberName = repository?.findIdByEmail(request.email)?.nickname
        var roleMember = repository?.findIdByEmail(request.email)?.role

        val jwtToken: String? = user?.let { jwtService?.generateToken(it) }
        return AuthenticationResponse().apply {
            token=jwtToken
            username = memberName
            memberRole = roleMember
            userId = idMember
        }
    }
}