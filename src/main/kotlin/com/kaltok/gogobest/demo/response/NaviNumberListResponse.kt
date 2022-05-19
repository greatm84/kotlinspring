package com.kaltok.gogobest.demo.response

data class NaviNumberListResponse(
    override val resultCode: String,
    val numberList: List<String>
) : BaseResponse
