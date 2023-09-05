package com.example.test.retrofit.weatherApi.dataClass

data class Day(
    val avghumidity: Double,
    val avgtemp_c: Double,
    val condition: Condition,
    val daily_will_it_rain: Int,
    val daily_will_it_snow: Int,
    val maxtemp_c: Double,
    val maxwind_kph: Double,
    val mintemp_c: Double,
    val totalprecip_mm: Double,
    val totalsnow_cm: Double,
    val uv: Double
)