package com.navitech.navi.utils

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object LayoutUtils {
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

}