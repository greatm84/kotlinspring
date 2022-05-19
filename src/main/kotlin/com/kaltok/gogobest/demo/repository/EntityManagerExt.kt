package com.kaltok.gogobest.demo.repository

import javax.persistence.EntityManager

fun <T> EntityManager.add(data: T): T {
    persist(data)
    flush()
    return data
}

fun <T> EntityManager.add(dataList: List<T>): List<T> {
    transaction.begin()

    val it = dataList.iterator()
    while (it.hasNext()) {
        val enquiry = it.next()
        persist(enquiry)
        flush()
        clear()
    }

    transaction.commit()

    return dataList
}

fun <T> EntityManager.getList(count: Int = 0, classOfT: Class<T>): List<T> {
    val query = createQuery("select m from ${classOfT.simpleName} m", classOfT)
    if (count > 0) {
        query.maxResults = count
    }
    return query.resultList
}

fun <T> EntityManager.getListByParamMap(
    paramMap: Map<String, String>,
    classOfT: Class<T>,
    count: Int = 0,
    ordering: String? = null
): List<T> {
    val builder = StringBuilder("select m from ${classOfT.simpleName} m ")

    if (paramMap.isNotEmpty()) {
        builder.append("where ")
    }

    paramMap.forEach { (key, _) ->
        builder.append("m.$key = :$key ")
    }

    if (ordering != null) {
        builder.append(ordering)
    }

    val emQuery = createQuery(builder.toString(), classOfT)

    paramMap.forEach { (key, value) ->
        emQuery.setParameter(key, value)
    }

    if (count > 0) {
        emQuery.maxResults = count
    }

    return emQuery.resultList
}

fun <T> EntityManager.deleteAll(classOfT: Class<T>) {
    createQuery("delete from ${classOfT::getSimpleName} m")
        .executeUpdate()
}