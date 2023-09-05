package com.example.test.retrofit.yandex.dataclass

data class YandexWeather(
    val fact: Fact,
    val forecasts: List<Forecast>,
    val info: Info,
    val now: Int,
    val yesterday: Yesterday
)