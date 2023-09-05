package com.example.test.retrofit.weatherApi.dataClass

data class Current(
    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Double,
    val humidity: Int,
    val is_day: Int,
    val last_updated: String,
    val last_updated_epoch: Int,
    val pressure_mb: Double,
    val temp_c: Double,
    val wind_kph: Double
)