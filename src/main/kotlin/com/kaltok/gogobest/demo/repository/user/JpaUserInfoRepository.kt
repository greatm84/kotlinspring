package com.kaltok.gogobest.demo.repository.user

import com.kaltok.gogobest.demo.model.user.UserInfo
import com.kaltok.gogobest.demo.repository.add
import com.kaltok.gogobest.demo.repository.deleteAll
import com.kaltok.gogobest.demo.repository.getList
import com.kaltok.gogobest.demo.repository.getListByParamMap
import javax.persistence.EntityManager

class JpaUserInfoRepository(private val em: EntityManager) : UserInfoRepository {

    override fun add(data: UserInfo): UserInfo {
        return em.add(data)
    }

    override fun add(dataList: List<UserInfo>): List<UserInfo> {
        em.transaction.begin()

        val it = dataList.iterator()
        while (it.hasNext()) {
            val enquiry = it.next()
            em.persist(enquiry)
            em.flush()
            em.clear()
        }

        em.transaction.commit()

        return dataList
    }

    fun getById(id: String): UserInfo? {
        return em.find(UserInfo::class.java, id)
    }

    override fun getList(count: Int): List<UserInfo> {
        return em.getList(count, UserInfo::class.java)
    }

    override fun getListByParamMap(paramMap: Map<String, String>, count: Int): List<UserInfo> {
        return em.getListByParamMap(paramMap, UserInfo::class.java, count)
    }

    override fun delete(data: UserInfo) {
        em.createQuery("delete from UserInfo m where m.id = ${data.id}")
            .executeUpdate()
    }

    override fun deleteAll() {
        em.deleteAll(UserInfo::class.java)
    }
}