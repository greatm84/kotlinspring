package com.kaltok.gogobest.demo

import com.kaltok.gogobest.demo.repository.JpaMemberRepository
import com.kaltok.gogobest.demo.repository.MemberRepository
import com.kaltok.gogobest.demo.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
class SpringConfig {

    @PersistenceContext
    private lateinit var em: EntityManager

    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository())
    }

    @Bean
    fun memberRepository(): MemberRepository {
        return JpaMemberRepository(em)
    }
}