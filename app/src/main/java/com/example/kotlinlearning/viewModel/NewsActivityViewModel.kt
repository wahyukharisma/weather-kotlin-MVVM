package com.example.kotlinlearning.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlinlearning.network.model.News
import com.example.kotlinlearning.repository.NewsActivityRepository

class NewsActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val _repositories = NewsActivityRepository(application)

    val listArticles : LiveData<News>
    val showProgress : LiveData<Boolean>

    init {
        this.listArticles = _repositories.listArticles
        this.showProgress = _repositories.showProgress
    }

    fun getArticles(){
        _repositories.getArticles()
    }
}