package com.example.kotlinlearning.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.kotlinlearning.repository.DetailActivityRepository

class DetailActivityViewModel(application: Application) : AndroidViewModel(application) {
    val repository = DetailActivityRepository(application)
}