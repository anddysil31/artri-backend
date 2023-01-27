package com.example.artribackend.repository

import com.example.artribackend.model.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository:JpaRepository<Member, Long> {
    fun findById(id: Long?):Member?
}