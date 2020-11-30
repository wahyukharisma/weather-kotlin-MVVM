package com.example.kotlinlearning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinlearning.R
import com.example.kotlinlearning.viewModel.NewsActivityViewModel
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    private lateinit var viewModel: NewsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        viewModel = ViewModelProvider(this).get(NewsActivityViewModel::class.java)

        btn_getData.setOnClickListener {
            viewModel.getArticles()
        }

        viewModel.listArticles.observe(this, Observer {
            tv_data.text = it.toString()
        })

        viewModel.showProgress.observe(this, Observer {
            if(it){
                pb_news.visibility = View.VISIBLE
            }else{
                pb_news.visibility = View.GONE
            }
        })
    }
}