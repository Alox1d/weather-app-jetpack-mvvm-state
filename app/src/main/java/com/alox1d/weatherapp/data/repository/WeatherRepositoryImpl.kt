package com.alox1d.weatherapp.data.repository

import com.alox1d.weatherapp.data.mappers.toWeatherInfo
import com.alox1d.weatherapp.data.remote.WeatherApi
import com.alox1d.weatherapp.domain.repository.WeatherRepository
import com.alox1d.weatherapp.domain.util.Resource
import com.alox1d.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(lat = lat, long = long).toWeatherInfo()
            )
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}