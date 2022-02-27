package com.navitech.navi.data.model

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("status") var status: String,
    @SerializedName("code") val code: Int,
    @SerializedName("data") val data: Object
) {
    fun isSuccess(): Boolean {
        return status == "success"
    }
}