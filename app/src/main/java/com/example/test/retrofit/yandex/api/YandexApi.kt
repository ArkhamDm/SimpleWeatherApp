package com.example.test.retrofit.yandex.api

import com.example.test.retrofit.weatherApi.dataClass.WeatherApiDataClass
import com.example.test.retrofit.yandex.dataclass.YandexWeather
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface YandexApi {
    @GET("forecast.json?key=8ab5456d4dcf489594d82333231307&q=London&days=3&aqi=no&alerts=no")
    //suspend fun getWeather(@Query("lat") lat : Double, @Query("lon") lon : Double): YandexWeather
    suspend fun getWeather(@Query("q") q : String): WeatherApiDataClass
}