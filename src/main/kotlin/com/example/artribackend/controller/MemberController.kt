package com.example.artribackend.controller

import com.example.artribackend.model.Member
import com.example.artribackend.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/member")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class MemberController {
    @Autowired
    lateinit var memberService: MemberService

    @GetMapping
    fun list():List<Member>{
        return memberService.list()
    }
}