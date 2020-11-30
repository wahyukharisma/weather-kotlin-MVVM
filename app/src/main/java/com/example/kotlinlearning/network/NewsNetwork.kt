package com.example.kotlinlearning.network

import com.example.kotlinlearning.network.model.News
import retrofit2.Call
import retrofit2.http.GET

const val NEWS_URL = "https://dennisgon.free.beeceptor.com/"

interface NewsNetwork{
    @GET("articles")
    fun getArticles() : Call<News>
}