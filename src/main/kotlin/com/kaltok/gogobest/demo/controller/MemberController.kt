package com.kaltok.gogobest.demo.controller

import com.kaltok.gogobest.demo.domain.Member
import com.kaltok.gogobest.demo.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MemberController(
    @Autowired
    private val memberService: MemberService
) {

    @GetMapping("/members/new")
    fun createForm(): String {
        return "members/createMemberForm"
    }

    @PostMapping("/members/new")
    fun create(form: MemberForm): String {
        val member = Member().apply { name = form.name }

        memberService.join(member)

        return "redirect:/"
    }

    @GetMapping("/members")
    fun list(model: Model):String{
        val members = memberService.findMembers()
        model.addAttribute("members", members)
        return "members/memberListm"
    }
}