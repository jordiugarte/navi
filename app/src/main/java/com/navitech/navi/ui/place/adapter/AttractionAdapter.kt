package com.navitech.navi.ui.place.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.navitech.navi.R
import com.navitech.navi.data.model.travel.attraction.Attraction
import com.navitech.navi.utils.LayoutUtils
import com.navitech.navi.utils.Router

class AttractionAdapter(val context: Activity, val data: List<Attraction>) :
    RecyclerView.Adapter<AttractionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attraction, parent, false)
        return AttractionAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val attraction: Attraction = data[position]
        LayoutUtils.setImage(context, attraction.photos[0], holder.image)
        holder.title.text = attraction.name
        holder.description.text = attraction.description
        holder.itemView.setOnClickListener { Router.toAttraction(context, attraction) }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.item_attraction_image)
        val title: TextView = itemView.findViewById(R.id.item_attraction_title)
        val description: TextView = itemView.findViewById(R.id.item_attraction_description)
    }
}