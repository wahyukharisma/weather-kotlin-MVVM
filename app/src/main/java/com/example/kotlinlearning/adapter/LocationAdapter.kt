package com.example.kotlinlearning.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlearning.R
import com.example.kotlinlearning.network.model.Location
import kotlinx.android.synthetic.main.rv_location_child.view.*

class LocationAdapter( private val context: Context) :
    RecyclerView.Adapter<LocationAdapter.ViewHolder>(){
    private var list: List<Location> = ArrayList()

    fun setLocationList(list: List<Location>){
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        val name = v.tv_location_name!!
        val latLng = v.tv_lat_lng!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.rv_location_child,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LocationAdapter.ViewHolder, position: Int) {
        holder.name.text = list[position].title
        holder.latLng.text = list[position].latt_long
    }

    override fun getItemCount(): Int {
        return list.size
    }
}