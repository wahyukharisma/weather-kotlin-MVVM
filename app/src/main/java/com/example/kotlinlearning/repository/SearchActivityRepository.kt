package com.example.kotlinlearning.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.kotlinlearning.network.BASE_URL
import com.example.kotlinlearning.network.WeatherNetwork
import com.example.kotlinlearning.network.model.Location
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivityRepository(val application: Application) {

    // MutableLiveData merupakan LiveData yang dapat dirubah nilainya
    val showProgress = MutableLiveData<Boolean>()
    val locationList = MutableLiveData<List<Location>>()

    fun changeState(){
       showProgress.value = !(showProgress.value !=null && showProgress.value!!)
    }

    fun searchLocation(searchstring: String){
        showProgress.value = true
        // Networkcall

        val retrofit =  Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(WeatherNetwork::class.java)

        service.getLocation(searchstring).enqueue(object :  Callback<List<Location>>{
            override fun onResponse(
                call: Call<List<Location>>,
                response: Response<List<Location>>
            ) {
                showProgress.value = false
                Log.d("SearchRepository", "Response : ${Gson().toJson(response.body())}")
                locationList.value = response.body()
            }

            override fun onFailure(call: Call<List<Location>>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application,"Error while accesing the API", Toast.LENGTH_SHORT)
            }

        })
    }
}