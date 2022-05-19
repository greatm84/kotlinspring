package com.kaltok.gogobest.demo.response

data class NaviNickNameListResponse(
    override val resultCode: String,
    val nickNameList: List<String>
) : BaseResponse
