package com.navitech.navi.ui.main.fragments.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.navitech.navi.R
import com.navitech.navi.data.model.attractions.Category
import com.navitech.navi.utils.CategoryLocator
import com.navitech.navi.utils.Router

class CategoriesAdapter(
    private val context: Context,
    private val data: MutableList<Category>
) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category: Category = data[position]
        holder.title.text = CategoryLocator.getName(category, context)
        holder.itemView.setOnClickListener {
            Router.toCategory(context, category)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.recommendation_title)
    }
}