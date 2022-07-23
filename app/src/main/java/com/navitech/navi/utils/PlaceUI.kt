package com.navitech.navi.utils

import android.app.Activity
import android.widget.ImageView
import android.widget.TextView
import com.navitech.navi.R
import com.navitech.navi.data.model.weather.WeatherResult
import java.util.*

object PlaceUI {

    fun initialize(view: Activity, data: WeatherResult?) {
        val city: TextView = view.findViewById(R.id.item_current_place_city)
        val country: TextView = view.findViewById(R.id.item_current_place_country)
        val climate: TextView = view.findViewById(R.id.item_current_place_climate)
        val time: TextView = view.findViewById(R.id.item_current_place_time)
        val background: ImageView = view.findViewById(R.id.item_current_place_background)
        if (data != null) {
            LayoutUtils.setImage(
                view,
                "https://img.theculturetrip.com/1440x807/smart/wp-content/uploads/2017/01/shutterstock_212973553-la-paz-is-a-city-in-the-clouds.jpg",
                background
            )
            city.text = data.name
            country.text = data.sys.country
            climate.text = (data.main.temp - 270.0).toInt().toString() + "°C"
            time.text = DateFormat.dateToString(Date(data.dt * 1000), DateFormat.FORMAT_TYPE.ONLY_TIME)
        }
    }
}