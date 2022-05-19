package com.kaltok.gogobest.demo

import com.kaltok.gogobest.demo.repository.JpaNaviInfoRepository
import com.kaltok.gogobest.demo.repository.MemberRepository
import com.kaltok.gogobest.demo.repository.MemoryMemberRepository
import com.kaltok.gogobest.demo.repository.NaviInfoRepository
import com.kaltok.gogobest.demo.repository.user.JpaUserInfoRepository
import com.kaltok.gogobest.demo.repository.user.UserInfoRepository
import com.kaltok.gogobest.demo.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager

@Configuration
class SpringConfig {

    @Autowired
    lateinit var em: EntityManager

    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository())
    }

    @Bean
    fun memberRepository(): MemberRepository {
        return MemoryMemberRepository()
    }

    @Bean
    fun naviRepository(): NaviInfoRepository {
        return JpaNaviInfoRepository(em)
    }

    @Bean
    fun userInfoRepository(): UserInfoRepository {
        return JpaUserInfoRepository(em)
    }
}