package com.example.kotlinlearning.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlearning.R
import com.example.kotlinlearning.network.model.Location
import com.example.kotlinlearning.view.DetailActivity
import kotlinx.android.synthetic.main.rv_location_child.view.*

class LocationAdapter( private val context: Context) :
    RecyclerView.Adapter<LocationAdapter.ViewHolder>(){
    private var _list: List<Location> = ArrayList()

    fun setLocationList(list: List<Location>){
        this._list = list
        notifyDataSetChanged()
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        val name = v.tv_location_name!!
        val latLng = v.tv_lat_lng!!
        val rootView = v.child_root
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
        holder.name.text = _list[position].title
        holder.latLng.text = _list[position].latt_long

        holder.rootView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("title",_list[position].title)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return _list.size
    }
}