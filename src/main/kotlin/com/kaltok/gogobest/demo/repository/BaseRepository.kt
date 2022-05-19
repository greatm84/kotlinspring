package com.kaltok.gogobest.demo.repository

interface BaseRepository<T> {

    fun add(data: T): T

    fun add(dataList: List<T>): List<T>

    fun getList(count: Int = 0): List<T>

    fun getListByParamMap(paramMap: Map<String, String>, count: Int = 0): List<T>

    fun delete(data: T)

    fun deleteAll()
}