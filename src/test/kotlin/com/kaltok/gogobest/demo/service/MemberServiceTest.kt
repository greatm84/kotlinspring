package com.kaltok.gogobest.demo.service

import com.kaltok.gogobest.demo.domain.Member
import com.kaltok.gogobest.demo.repository.MemoryMemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemberServiceTest {

    private val memberRepository = MemoryMemberRepository()
    private val memberService = MemberService(memberRepository)

    @Test
    fun 회원가입() {
        val member = Member().apply { name = "hello" }

        val saveId = memberService.join(member)

        val result = memberService.findOne(saveId).get()
        assertThat(member.name).isEqualTo(result.name)
    }

    @Test
    fun findMembers() {
    }

    @Test
    fun findOne() {
    }
}