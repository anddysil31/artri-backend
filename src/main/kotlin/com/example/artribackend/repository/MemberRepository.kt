package com.example.artribackend.repository

import com.example.artribackend.model.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberRepository:JpaRepository<Member, Long> {
    fun findByNickname(nickname: String?): Optional<Member?>
}