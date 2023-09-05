package com.example.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.retrofit.weatherApi.api.WeatherAPI
import com.example.test.retrofit.weatherApi.dataClass.Forecastday
import com.example.test.retrofit.weatherApi.dataClass.WeatherApiDataClass
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TempViewModel: ViewModel() {
    private val _weather = MutableLiveData<WeatherApiDataClass>()
    val weather: LiveData<WeatherApiDataClass> get() = _weather
    var tempGraph: Forecastday? = null

    init {
        getWeather("Saint-Petersburg")
    }

    fun getWeather(city: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val weatherApi = retrofit.create(WeatherAPI::class.java)

        viewModelScope.launch {
            _weather.value = weatherApi.getWeather(city)
        }
    }

    fun showTempGraph(day: Int) {
        when (day) {
            0 -> tempGraph = weather.value?.forecast?.forecastday?.get(0)
            1 -> tempGraph = weather.value?.forecast?.forecastday?.get(1)
            2 -> tempGraph = weather.value?.forecast?.forecastday?.get(2)
        }
    }
}