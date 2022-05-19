package com.kaltok.gogobest.demo.repository

import com.kaltok.gogobest.demo.model.NaviInfo
import javax.persistence.EntityManager

class JpaNaviInfoRepository(private val em: EntityManager) : NaviInfoRepository {

    override fun save(naviInfo: NaviInfo): NaviInfo {
        em.persist(naviInfo)
        return naviInfo
    }

    override fun findById(id: Long): NaviInfo? {
        return em.find(NaviInfo::class.java, id)
    }

    override fun getListByNickName(nickName: String): List<NaviInfo> {
        return em.createQuery(
            "select m from NaviInfo m where m.nickName = :nickName order by m.timeStamp desc",
            NaviInfo::class.java
        )
            .setParameter("nickName", nickName)
            .resultList
    }

    override fun getListByNumber(number: String): List<NaviInfo> {
        return em.createQuery(
            "select m from NaviInfo m where m.number = :number order by m.timeStamp desc",
            NaviInfo::class.java
        )
            .setParameter("number", number)
            .resultList
    }

    override fun getListByParamMap(paramMap: Map<String, String>, count: Int): List<NaviInfo> {
        val builder = StringBuilder("select m from NaviInfo m ")

        if (paramMap.isNotEmpty()) {
            builder.append("where ")
        }

        paramMap.forEach { (key, _) ->
            builder.append("m.$key = :$key ")
        }

        builder.append("order by m.timeStamp desc")

        val emQuery = em.createQuery(builder.toString(), NaviInfo::class.java)

        paramMap.forEach { (key, value) ->
            emQuery.setParameter(key, value)
        }

        if (count > 0) {
            emQuery.maxResults = count
        }

        return emQuery.resultList
    }

    override fun getNickNameList(allList: List<NaviInfo>, count: Int): List<String> {
        val result = allList.sortedBy { it.timeStamp }
            .distinctBy { it.nickName }
            .map { it.nickName }

        if (count > 0) {
            return result.take(count)
        }

        return result
    }

    override fun getNumberList(allList: List<NaviInfo>, count: Int): List<String> {
        val result = allList.sortedBy { it.timeStamp }
            .distinctBy { it.number }
            .map { it.number }

        if (count > 0) {
            return result.take(count)
        }

        return result
    }

    override fun getList(count: Int): List<NaviInfo> {
        val emQuery = em.createQuery("select m from NaviInfo m order by m.timeStamp desc ", NaviInfo::class.java)
        if (count > 0) {
            emQuery.maxResults = count
        }
        return emQuery.resultList
    }

    override fun deleteTimeStampItemsLessThanDeadline(deadline: Long) {
        em.createQuery("delete from NaviInfo m where m.timeStamp < :deadline")
            .setParameter("deadline", deadline)
            .executeUpdate()
    }

    override fun deleteAll() {
        em.createQuery("delete from NaviInfo m")
            .executeUpdate()
    }
}