package com.example.kotlinlearning.network

import com.example.kotlinlearning.network.model.Location
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
const val BASE_URL = "https://www.metaweather.com/api/location/"

interface WeatherNetwork {
    @GET("search?")
    fun getLocation(@Query("query")searchString: String) : Call<List<Location>>
}