package com.navitech.navi.data.model.weather

import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all") var all: Int = 0,
)