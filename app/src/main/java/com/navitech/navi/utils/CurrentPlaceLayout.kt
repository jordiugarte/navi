package com.navitech.navi.utils

import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.navitech.navi.R

class CurrentPlaceLayout {
    var activity: Activity
    var layout: View
    var background: ImageView
    var city: TextView
    var country: TextView
    var time: TextView
    var weather: TextView
    var status: TextView

    constructor(activity: Activity, view: View) {
        this.activity = activity
        layout = view.findViewById(R.id.layout_current_location)
        background = view.findViewById(R.id.item_current_place_background)
        city = view.findViewById(R.id.item_current_place_city)
        country = view.findViewById(R.id.item_current_place_country)
        time = view.findViewById(R.id.item_current_place_time)
        weather = view.findViewById(R.id.item_current_place_climate)
        status = view.findViewById(R.id.item_current_place_status)
        layout.setOnClickListener {
            Router.toPlace(activity)
        }
    }

    constructor(activity: Activity) {
        this.activity = activity
        layout = activity.findViewById(R.id.layout_current_location)
        background = activity.findViewById(R.id.item_current_place_background)
        city = activity.findViewById(R.id.item_current_place_city)
        country = activity.findViewById(R.id.item_current_place_country)
        time = activity.findViewById(R.id.item_current_place_time)
        weather = activity.findViewById(R.id.item_current_place_climate)
        status = activity.findViewById(R.id.item_current_place_status)
    }

    fun setData() {
        LayoutUtils.setImage(
            activity,
            "https://img.theculturetrip.com/1440x807/smart/wp-content/uploads/2017/01/shutterstock_212973553-la-paz-is-a-city-in-the-clouds.jpg",
            background
        )
        city.setText("La Paz")
        country.setText("Bolivia")
        time.setText("22:53")
        weather.setText("24")
        status.setText("Current location")
    }
}