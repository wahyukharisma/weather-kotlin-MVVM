package com.example.kotlinlearning.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlinlearning.network.model.Location
import com.example.kotlinlearning.repository.SearchActivityRepository

class SearchActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val _repository = SearchActivityRepository(application)

    // Tentang livedata
    // https://medium.com/nusanet/android-jetpack-basic-of-livedata-c2fddb7927f7#:~:text=Jadi%2C%20LiveData%20adalah%20sebuah%20class,Activity%20%2C%20Fragment%20%2C%20atau%20Service%20.
    val showProgress : LiveData<Boolean>
    val locationList : LiveData<List<Location>>

    init {
        this.showProgress = _repository.showProgress
        this.locationList = _repository.locationList
    }

    fun changeState(){
        _repository.changeState()
    }

    fun searchLocation(searchstring: String){
        _repository.searchLocation(searchstring)
    }
}