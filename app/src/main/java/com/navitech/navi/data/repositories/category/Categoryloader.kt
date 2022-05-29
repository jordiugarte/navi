package com.navitech.navi.data.repositories

import com.navitech.navi.data.model.travel.Category
import com.parse.FindCallback

interface CategoryLoader {
    fun loadAll(callback: FindCallback<Category>)
}