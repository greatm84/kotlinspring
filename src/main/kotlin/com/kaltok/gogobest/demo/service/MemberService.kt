package com.kaltok.gogobest.demo.service

import com.kaltok.gogobest.demo.model.Member
import com.kaltok.gogobest.demo.repository.MemberRepository
import java.util.*

open class MemberService(private val memberRepository: MemberRepository) {

    fun join(member: Member): Long {
        validateDuplicateMember(member)

        memberRepository.save(member)
        return member.id
    }

    private fun validateDuplicateMember(member: Member) {
        memberRepository.findByName(member.name).ifPresent {
            throw IllegalStateException("이미 존재하는 회원입니다")
        }
    }

    fun findMembers(): List<Member> {
        return memberRepository.findAll()
    }

    fun findOne(memberId: Long): Optional<Member> {
        return memberRepository.findById(memberId)
    }
}