package com.navitech.navi.data.local

import android.content.Context
import android.util.Log
import com.navitech.navi.ui.parser.AssetBuffer
import org.json.JSONArray

class ParametersData {

    val COUNTRIES = 0

    fun getCountries(context: Context): JSONArray {
        return JSONArray(AssetBuffer().getStaticData(context, COUNTRIES))
    }
}