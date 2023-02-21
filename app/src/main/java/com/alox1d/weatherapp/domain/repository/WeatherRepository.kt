package com.alox1d.weatherapp.domain.repository

import com.alox1d.weatherapp.domain.util.Resource
import com.alox1d.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}