package com.navitech.navi.utils

import android.app.Activity
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.navitech.navi.R

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
        Glide.with(context).load(url).into(imageView);
    }
}