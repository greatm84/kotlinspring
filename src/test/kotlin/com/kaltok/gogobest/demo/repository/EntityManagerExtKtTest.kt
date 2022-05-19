package com.kaltok.gogobest.demo.repository

import com.kaltok.gogobest.demo.model.user.UserInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EntityManagerExtKtTest {

    @Test
    fun `clazz test`() {
        assertThat(UserInfo::class.java.simpleName).isEqualTo("UserInfo")
    }
}