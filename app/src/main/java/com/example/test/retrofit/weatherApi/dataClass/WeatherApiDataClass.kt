package com.example.test.retrofit.weatherApi.dataClass

data class WeatherApiDataClass(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)