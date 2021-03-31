package com.kaltok.gogobest.demo.repository

import com.kaltok.gogobest.demo.domain.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class MemoryMemberRepositoryTest {

    private val repository = MemoryMemberRepository()

    @AfterEach
    fun afterEach() {
        repository.clearStore()
    }

    @Test
    fun save() {
        val member = Member()
        member.name = "spring"

        repository.save(member)

        val result = repository.findById(member.id).get()

        assertThat(member).isEqualTo(result)
    }

    @Test
    fun `find by name Test`() {
        val member1 = Member().apply { name = "spring1" }
        repository.save(member1)

        val member2 = Member().apply { name = "spring2" }
        repository.save(member2)

        val result = repository.findByName("spring1").get()

        assertThat(result).isEqualTo(member1)
    }

    @Test
    fun findAll() {
        val member1 = Member().apply { name = "spring1" }
        repository.save(member1)

        val member2 = Member().apply { name = "spring2" }
        repository.save(member2)

        val result = repository.findAll()

        assertThat(result.size).isEqualTo(2)
    }
}