package com.example.test.retrofit.yandex.dataclass

data class Fact(
    val condition: String,
    val daytime: String,
    val feels_like: Int,
    val humidity: Int,
    val icon: String,
    val is_thunder: Boolean,
    val obs_time: Int,
    val season: String,
    val temp: Int,
    val wind_speed: Double
)