package com.navitech.navi.data.services.weather

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherClient {
    private var retrofit: Retrofit? = null

    val URL = "https://api.openweathermap.org"
    val KEY = "6babd861bd97c6175f80b1efbafcb713"

    private fun getWeatherClientInstance(): Retrofit? {
        if (retrofit == null) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit
    }

    fun <S> createService(serviceClass: Class<S>): S {
        return getWeatherClientInstance()!!.create(serviceClass)
    }
}