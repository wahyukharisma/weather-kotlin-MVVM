package com.example.kotlinlearning.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.kotlinlearning.network.NEWS_URL
import com.example.kotlinlearning.network.NewsNetwork
import com.example.kotlinlearning.network.model.News
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsActivityRepository(val application: Application) {

    var listArticles = MutableLiveData<News>()
    val showProgress = MutableLiveData<Boolean>()

    fun getArticles(){
        showProgress.value = true
        val retrofit = Retrofit.Builder().baseUrl(NEWS_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

        val services = retrofit.create(NewsNetwork::class.java)

        services.getArticles().enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                showProgress.value = false
                Log.d("SearchRepository", "Response : ${Gson().toJson(response.body())}")
                listArticles.value = response.body()
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application,"Error while accesing the API", Toast.LENGTH_SHORT)
            }
        })
    }
}