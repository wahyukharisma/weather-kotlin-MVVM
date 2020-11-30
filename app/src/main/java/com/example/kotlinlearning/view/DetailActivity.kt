package com.example.kotlinlearning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinlearning.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if(intent.hasExtra("title")){
            tv_title.text = intent.getStringExtra("title")
        }
    }
}