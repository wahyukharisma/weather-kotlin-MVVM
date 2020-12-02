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

    companion object{
        val ITEM_A = 1
        val ITEM_B = 2
    }

    private var _list: List<Location> = ArrayList()

    fun setLocationList(list: List<Location>){
        this._list = list
        notifyDataSetChanged()
    }

    open inner class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        val name = v.tv_location_name!!
        val latLng = v.tv_lat_lng!!
        val rootView = v.child_root!!
    }

    inner class ViewHolderA(v: View): ViewHolder(v)
    inner class ViewHolderB(v: View): ViewHolder(v)

    override fun getItemViewType(position: Int): Int {
        return when(_list[position].title){
            "Mumbai" -> ITEM_A
            "Dubai" -> ITEM_B
            else -> ITEM_B
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            ITEM_A -> ViewHolderA(inflater.inflate(R.layout.rv_location_child,null))
            ITEM_B -> ViewHolderB(inflater.inflate(R.layout.rv_location_child_sub, null))
            else -> ViewHolderA(inflater.inflate(R.layout.rv_location_child,null))
        }
    }

    override fun onBindViewHolder(holder: LocationAdapter.ViewHolder, position: Int) {

        when(_list[position].title){
            "Mumbai" -> {
                val viewHolderA = holder as ViewHolderA
                viewHolderA.name.text = _list[position].title
                viewHolderA.latLng.text = _list[position].latt_long

                viewHolderA.rootView.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("title",_list[position].title)
                    context.startActivity(intent)
                }
            }
            "Dubai" -> {
                val viewHolderB = holder as ViewHolderB
                viewHolderB.name.text = _list[position].title
                viewHolderB.latLng.text = _list[position].latt_long

                viewHolderB.rootView.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("title",_list[position].title)
                    context.startActivity(intent)
                }
            }
            else -> {
                val viewHolderB = holder as ViewHolderB
                viewHolderB.name.text = _list[position].title
                viewHolderB.latLng.text = _list[position].latt_long

                viewHolderB.rootView.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("title",_list[position].title)
                    context.startActivity(intent)
                }
            }
        }


    }

    override fun getItemCount(): Int {
        return _list.size
    }
}