package com.kaltok.gogobest.demo.repository

import com.kaltok.gogobest.demo.domain.Member
import java.util.*
import javax.persistence.EntityManager

class JpaMemberRepository(private val em: EntityManager) : MemberRepository {

    override fun save(member: Member): Member {
        em.persist(member)
        return member
    }

    override fun findById(id: Long): Optional<Member> {
        return Optional.ofNullable(em.find(Member::class.java, id))
    }

    override fun findByName(name: String): Optional<Member> {
//        return em.createQuery("select m from Member m where m.name = :name", Member::class.java)
//            .setParameter("name", name).resultList.stream().findAny()
        return em.createQuery("select m from Member m where m.name = $name", Member::class.java)
            .resultList.stream().findAny()
    }

    override fun findAll(): List<Member> {
        return em.createQuery("select m from Member m ", Member::class.java).resultList
    }

    override fun clearStore() {
        TODO("Not yet implemented")
    }
}