package com.example.kotlinlearning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.HandlerCompat
import com.example.kotlinlearning.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val r = Runnable {
            startActivity(Intent(this, SearchActivity::class.java))
            finish()
        }

        Handler(Looper.getMainLooper()).postDelayed(r,2000)
    }
}