package com.navitech.navi.utils

import android.app.Activity
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.navitech.navi.R
import com.navitech.navi.data.local.ParametersData
import com.navitech.navi.ui.NaviActivity

object LayoutUtils {

    fun setToolbar(context: AppCompatActivity, title: String) {
        val toolbar = context.findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = title
        //toolbar.setTitleTextAppearance(context, R.style.lightToolbar)
        context.setSupportActionBar(toolbar)
        context.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        context.supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    fun setToolbar(context: AppCompatActivity) {
        setToolbar(context, "")
    }

    fun setRecyclerView(context: Activity, id: Int, orientation: Int): RecyclerView {
        val result: RecyclerView = context.findViewById(id)
        result.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        result.layoutManager = layoutManager
        layoutManager.orientation = orientation
        return result
    }

    fun setRecyclerView(context: Activity, view: View, id: Int, orientation: Int): RecyclerView {
        val result: RecyclerView = view.findViewById(id)
        result.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context)
        result.layoutManager = layoutManager
        layoutManager.orientation = orientation
        return result
    }

    fun setImage(context: Activity, url: String, imageView: ImageView) {
        Glide.with(context).load(url).error(R.drawable.placeholder).into(imageView)
    }

    fun setImage(context: FragmentActivity, url: String, imageView: ImageView) {
        Glide.with(context).load(url).error(R.drawable.placeholder).into(imageView)
    }

    fun setChipCategories(context: NaviActivity, categories: ArrayList<Int>, chipGroup: ChipGroup) {
        for (i in 0 until categories.size) {
            val chip = Chip(ContextThemeWrapper(context, R.style.chip_category))
            chip.text = ParametersData().getCategoryName(categories[i], context)
            chipGroup.addView(chip)
        }
    }
}