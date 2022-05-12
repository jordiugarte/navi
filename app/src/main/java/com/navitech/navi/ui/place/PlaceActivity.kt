package com.navitech.navi.ui.place

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.navitech.navi.R
import com.navitech.navi.ui.place.adapter.AttractionAdapter
import com.navitech.navi.utils.CurrentPlaceLayout
import com.navitech.navi.utils.LayoutUtils

class PlaceActivity : AppCompatActivity() {
    private val activity: Activity = this

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place)
        initViews()
        setData()
    }

    private fun initViews() {
        CurrentPlaceLayout(activity).setData()
        recyclerView = LayoutUtils.setRecyclerView(activity, R.id.place_attractions_recycler_view, LinearLayout.VERTICAL)
    }

    private fun setData() {
        recyclerView.adapter = AttractionAdapter(activity)
    }
}