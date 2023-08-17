package com.example.artribackend.auth

import com.example.artribackend.model.Role


class AuthenticationResponse {
    var token: String? = null
    var username: String? = null
    var userId: Long? = null
    var memberRole: Role? = null
}