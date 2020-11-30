package com.example.kotlinlearning.view

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinlearning.R
import com.example.kotlinlearning.adapter.LocationAdapter
import com.example.kotlinlearning.viewModel.SearchActivityViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    // latein digunakan untuk mendeklarasikan variabel yang dapat berubah-ubah
    private lateinit var viewModel: SearchActivityViewModel
    private lateinit var adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        viewModel = ViewModelProvider(this).get(SearchActivityViewModel::class.java)

        iv_search.setOnClickListener {
            if (et_location.text!!.isNotEmpty())
                viewModel.searchLocation(et_location.text.toString())
        }

        // Memanggil observe dengan 2 parameter
        // Parameter pertama dikenal dengan lifecycle owner yang memberikan sinyak apakah activity/fragmen aktif atau tidak
        // Mengacu pada lifecycle owner maka akan mentrigger observer dan menjalankan fungsi di dalamnya dalam kasus ini mnegecek apakah
        // show progress bernilai true/false
        viewModel.showProgress.observe(this, Observer {
            if(it){
                pb_search.visibility = View.VISIBLE
            }else{
                pb_search.visibility = View.GONE
            }
        })

        viewModel.locationList.observe(this, Observer {
            adapter.setLocationList(it)
        })

        adapter = LocationAdapter(this)
        rv_search.adapter = adapter
    }
}