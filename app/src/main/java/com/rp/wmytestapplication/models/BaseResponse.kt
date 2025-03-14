package com.rp.wmytestapplication.models

data class BaseResponse<T>(
    val ResponseCode: Int,
    val ResponseMsg: String,
    val ResponseData: T
)


