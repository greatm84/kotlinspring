package com.kaltok.gogobest.demo.service

import com.kaltok.gogobest.demo.model.NaviInfo
import com.kaltok.gogobest.demo.repository.NaviInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.*
import javax.transaction.Transactional

@Component
class NaviInfoService {

    companion object {
        const val DELETE_DURATION = 1000 * 60 * 60 * 24L
    }

    @Autowired
    lateinit var repository: NaviInfoRepository

    @Transactional
    fun add(naviInfo: NaviInfo): Long {
        repository.save(naviInfo)
        return naviInfo.id
    }

    private fun validateDuplicateData(naviInfo: NaviInfo) {
        val info = repository.findById(naviInfo.id) ?: throw IllegalStateException("이미 존재하는 회원이 있으")
    }

    fun getAll(count: Int = 0): List<NaviInfo> {
        return repository.getList(count)
    }

    fun findOne(id: Long): NaviInfo? {
        return repository.findById(id)
    }

    fun findListByNumber(number: String, count: Int): List<NaviInfo> {
        return repository.getListByNumber(number).take(count)
    }

    fun findListByNickName(nickName: String, count: Int): List<NaviInfo> {
        return repository.getListByNickName(nickName).take(count)
    }

    fun findListByParamMap(paramMap: Map<String, String>, count: Int): List<NaviInfo> {
        return repository.getListByParamMap(paramMap, count)
    }

    fun getNickNameList(allList: List<NaviInfo>, count: Int = 0): List<String> {
        return repository.getNickNameList(allList, count)
    }

    fun getNumberList(allList: List<NaviInfo>, count: Int = 0): List<String> {
        return repository.getNumberList(allList, count)
    }

    @Scheduled(fixedDelay = DELETE_DURATION)
    @Transactional
    fun deleteItemsUnderDeadline() {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -5)

        repository.deleteTimeStampItemsLessThanDeadline(calendar.timeInMillis)
        println("deleteItemsUnderDeadline done")
    }

    @Transactional
    fun deleteAll() {
        repository.deleteAll()
    }
}