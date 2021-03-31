package com.kaltok.gogobest.demo.repository

import com.kaltok.gogobest.demo.domain.Member
import java.util.*

class MemoryMemberRepository : MemberRepository {

    override fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id] = member
        return member
    }

    override fun findById(id: Long): Optional<Member> {
        return Optional.ofNullable(store[id])
    }

    override fun findByName(name: String): Optional<Member> {
        return Optional.ofNullable(store.values.firstOrNull { it.name == name })
    }

    override fun findAll(): List<Member> {
        return store.values.toList()
    }

    override fun clearStore() {
        store.clear()
        sequence = 0
    }

    companion object {
        val store = hashMapOf<Long, Member>()

        var sequence = 0L;
    }
}