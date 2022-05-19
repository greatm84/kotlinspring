package com.kaltok.gogobest.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class NaviInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1
) {
    var number: String = ""
    var nickName: String = ""
    var timeStamp: Long = 0
    var geoLati: String = ""
    var geoLong: String = ""
}
