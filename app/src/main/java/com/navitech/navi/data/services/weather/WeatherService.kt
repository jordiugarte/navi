package com.navitech.navi.data.services.weather

import com.navitech.navi.data.model.weather.WeatherResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather")
    fun get(@Query("lat") lat: Double, @Query("lon") lon: Double, @Query("APPID") appId: String): Call<WeatherResult>
}