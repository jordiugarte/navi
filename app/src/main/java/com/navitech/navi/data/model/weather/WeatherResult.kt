package com.navitech.navi.data.model.weather

import com.google.gson.annotations.SerializedName

data class WeatherResult(
    @SerializedName("coord") var coord: Coord = Coord(),
    @SerializedName("weather") var weather: ArrayList<Weather> = arrayListOf(),
    @SerializedName("base") var base: String = "",
    @SerializedName("main") var main: Main = Main(),
    @SerializedName("visibility") var visibility: Int? = null,
    @SerializedName("wind") var wind: Wind = Wind(),
    @SerializedName("clouds") var clouds: Clouds = Clouds(),
    @SerializedName("dt") var dt: Long = 0,
    @SerializedName("sys") var sys: Sys = Sys(),
    @SerializedName("timezone") var timezone: Int? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cod") var cod: Int? = null
)