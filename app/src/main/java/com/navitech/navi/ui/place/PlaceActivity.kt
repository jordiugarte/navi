package com.navitech.navi.ui.place

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.navitech.navi.R
import com.navitech.navi.data.model.weather.WeatherResult
import com.navitech.navi.data.services.weather.WeatherRepository
import com.navitech.navi.ui.NaviActivity
import com.navitech.navi.ui.place.adapter.AttractionAdapter
import com.navitech.navi.utils.LayoutUtils
import com.navitech.navi.utils.PlaceUI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceActivity : NaviActivity() {
    private val activity: Activity = this

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place)
        initViews()
        setData()
    }

    private fun initViews() {
        LayoutUtils.setToolbar(this)
        recyclerView = LayoutUtils.setRecyclerView(activity, R.id.place_attractions_recycler_view, LinearLayout.VERTICAL)
    }

    private fun setData() {
        recyclerView.adapter = AttractionAdapter(activity)
        WeatherRepository().get(-16.496899, -68.098001).enqueue(
            object : Callback<WeatherResult> {
                override fun onResponse(
                    call: Call<WeatherResult>,
                    response: Response<WeatherResult>
                ) {
                    PlaceUI.initialize(activity, response.body()!!)
                }

                override fun onFailure(call: Call<WeatherResult>, t: Throwable) {
                    Log.e("error", t.message!!)
                }

            }
        )
    }
}