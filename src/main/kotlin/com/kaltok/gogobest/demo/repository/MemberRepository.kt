package com.kaltok.gogobest.demo.repository

import com.kaltok.gogobest.demo.model.Member
import java.util.*

interface MemberRepository {

    fun save(member: Member): Member

    fun findById(id: Long): Optional<Member>

    fun findByName(name: String): Optional<Member>

    fun findAll(): List<Member>

    fun clearStore()
}