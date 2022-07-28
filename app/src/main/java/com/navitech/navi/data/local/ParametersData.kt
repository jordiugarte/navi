package com.navitech.navi.data.local

import android.content.Context
import com.navitech.navi.R
import com.navitech.navi.data.model.travel.Category
import com.navitech.navi.ui.parser.AssetBuffer
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception


class ParametersData {

    val COUNTRIES = 0

    fun getCountries(context: Context): JSONArray {
        return JSONArray(AssetBuffer().getStaticData(context, COUNTRIES))
    }

    fun getCountryNameByCode(context: Context, code: String): String {
        val array = getCountries(context)
        for (i in 0 until array.length()) {
            val country: JSONObject = array.getJSONObject(i)
            val id = country.getString("sortname")
            if (id.equals(code)) {
                return country.getString("name")
            }
        }
        return ""
    }

    fun getCurrencyByCountry(context: Context, name: String): String {
        val array = getCountries(context)
        for (i in 0 until array.length()) {
            val country: JSONObject = array.getJSONObject(i)
            val countryName = country.getString("name")
            if (countryName.equals(name)) {
                return country.getString("currency_code")
            }
        }
        return ""
    }

    fun getCategoryName(category: Category, context: Context): String {
        return try {
            context.resources.getStringArray(R.array.category_names)[category.tag]
        } catch (e: Exception) {
            category.name
        }
    }

    fun getCategoryName(index: Int, context: Context): String {
        return try {
            context.resources.getStringArray(R.array.category_names)[index]
        } catch (e: Exception) {
            ""
        }
    }

    fun getCategoryDescription(category: Category, context: Context): String {
        return try {
            context.resources.getStringArray(R.array.category_descriptions)[category.tag]
        } catch (e: Exception) {
            category.description
        }
    }
}