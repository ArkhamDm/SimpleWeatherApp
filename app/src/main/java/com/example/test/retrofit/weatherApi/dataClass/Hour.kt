package com.example.test.retrofit.weatherApi.dataClass

data class Hour(
    val chance_of_rain: Int,
    val chance_of_snow: Int,
    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Double,
    val humidity: Int,
    val is_day: Int,
    val pressure_mb: Double,
    val temp_c: Double,
    val time: String,
    val time_epoch: Int,
    val will_it_rain: Int,
    val will_it_snow: Int,
    val wind_kph: Double
)