package com.example.artribackend.service

import com.example.artribackend.model.Member
import com.example.artribackend.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MemberService {
    @Autowired
    lateinit var memberRepository: MemberRepository

    fun list ():List<Member>{
        return memberRepository.findAll()
    }
}