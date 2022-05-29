package com.navitech.navi.utils

import android.content.Context
import com.navitech.navi.R
import com.navitech.navi.data.model.travel.Category
import java.lang.Exception

object CategoryLocator {
    fun getName(category: Category, context: Context): String {
        return try {
            context.resources.getStringArray(R.array.category_names)[category.tag]
        } catch (e: Exception) {
            category.name
        }
    }

    fun getDescription(category: Category, context: Context): String {
        return try {
            context.resources.getStringArray(R.array.category_descriptions)[category.tag]
        } catch (e: Exception) {
            category.description
        }
    }
}