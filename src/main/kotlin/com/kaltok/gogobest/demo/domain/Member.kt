package com.kaltok.gogobest.demo.domain

import javax.persistence.*

@Entity
class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    var name: String = ""
}
