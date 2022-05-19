package com.kaltok.gogobest.demo.repository

import com.kaltok.gogobest.demo.model.NaviInfo

interface NaviInfoRepository {
    fun save(naviInfo: NaviInfo): NaviInfo

    fun findById(id: Long): NaviInfo?

    fun getListByNickName(nickName: String): List<NaviInfo>

    fun getListByNumber(number: String): List<NaviInfo>

    fun getListByParamMap(paramMap: Map<String, String>, count: Int = 0): List<NaviInfo>

    fun getNickNameList(allList: List<NaviInfo>, count: Int = 0): List<String>

    fun getNumberList(allList: List<NaviInfo>, count: Int = 0): List<String>

    fun getList(count: Int = 0): List<NaviInfo>

    fun deleteTimeStampItemsLessThanDeadline(deadline: Long)

    fun deleteAll()
}