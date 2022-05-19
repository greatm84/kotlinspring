package com.kaltok.gogobest.demo.model.user

import com.kaltok.gogobest.demo.constant.RoleType
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class UserInfo(
    @Id
    val id: String = ""
) {
    var password: String = ""
    var role: Int = RoleType.GUEST.value

    // below values are index to data table
    var posIndex: Int = -1
    var historyIndex: Int = -1

    /* 언제까지 해당 계정이 접근 가능한지 */
    var expiredTime: Long = 0
}
