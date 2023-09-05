package com.example.test.retrofit.weatherApi.dataClass

data class Forecastday(
    val date: String,
    val date_epoch: Int,
    val day: Day,
    val hour: List<Hour>
)