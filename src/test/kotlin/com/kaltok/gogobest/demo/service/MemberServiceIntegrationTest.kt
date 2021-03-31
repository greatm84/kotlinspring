package com.kaltok.gogobest.demo.service

import com.kaltok.gogobest.demo.domain.Member
import com.kaltok.gogobest.demo.repository.MemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import javax.transaction.Transactional

@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader::class)
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    private lateinit var memberService: MemberService

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