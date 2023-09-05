package com.example.test.retrofit.weatherApi.api

import com.example.test.retrofit.weatherApi.dataClass.WeatherApiDataClass
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("forecast.json?key=8ab5456d4dcf489594d82333231307&days=3&aqi=no&alerts=no")
    //suspend fun getWeather(@Query("lat") lat : Double, @Query("lon") lon : Double): YandexWeather
    suspend fun getWeather(@Query("q") city : String): WeatherApiDataClass
}