package com.navitech.navi.ui.parser

import android.content.Context
import com.navitech.navi.utils.Constants.LOCATIONS
import java.io.IOException


class AssetBuffer {
    fun getStaticData(context: Context, type: Int): String {
        return try {
            val inputStreamReader = context.assets.open(LOCATIONS()[type])
            val size = inputStreamReader.available()
            val buffer = ByteArray(size)
            inputStreamReader.read(buffer)
            inputStreamReader.close()
            String(buffer)
        } catch (e: IOException) {
            ""
        }
    }
}