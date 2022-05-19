package com.kaltok.gogobest.demo.response

import com.kaltok.gogobest.demo.model.NaviInfo

data class NaviListResponse(
    override val resultCode: String,
    val naviInfoList: List<NaviInfo>
) : BaseResponse