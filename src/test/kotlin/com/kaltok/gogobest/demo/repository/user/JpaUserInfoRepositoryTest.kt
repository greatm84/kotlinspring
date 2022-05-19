package com.kaltok.gogobest.demo.repository.user

import com.kaltok.gogobest.demo.model.user.UserInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaUserInfoRepositoryTest {

    @Autowired
    private lateinit var em: TestEntityManager

    private lateinit var repository: UserInfoRepository

    @Before
    fun setUp() {
        repository = JpaUserInfoRepository(em.entityManager)
    }

    @Test
    fun add() {
        val info = UserInfo("KSH_TEST")
        val result = repository.add(info)
        val count = repository.getList().size

        assertThat(result.id).isEqualTo(info.id)
        assertThat(count).isEqualTo(1)
    }
}