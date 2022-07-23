package com.navitech.navi.data.services.weather

import com.navitech.navi.data.model.weather.WeatherResult
import retrofit2.Call

class WeatherRepository {
    fun get(lat: Double, lon: Double): Call<WeatherResult> {
        return WeatherClient().createService(WeatherService::class.java).get(lat, lon, WeatherClient().KEY)
    }
}