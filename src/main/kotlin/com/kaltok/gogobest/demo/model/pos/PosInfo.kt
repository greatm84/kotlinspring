package com.kaltok.gogobest.demo.model.pos

import javax.persistence.GeneratedValue
import javax.persistence.Id

data class PosInfo(
    @Id
    @GeneratedValue
    val id: Long
) {

}
