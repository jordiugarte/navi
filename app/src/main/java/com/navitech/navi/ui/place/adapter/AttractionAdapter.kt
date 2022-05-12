package com.navitech.navi.ui.place.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.navitech.navi.R
import com.navitech.navi.ui.main.fragments.home.adapter.RecommendationsAdapter
import com.navitech.navi.utils.Router

class AttractionAdapter(val context: Context) :
    RecyclerView.Adapter<AttractionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attraction, parent, false)
        return AttractionAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener { Router.toAttraction(context) }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}