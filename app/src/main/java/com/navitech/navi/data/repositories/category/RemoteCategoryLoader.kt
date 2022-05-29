package com.navitech.navi.data.repositories.category

import com.navitech.navi.data.model.travel.Category
import com.navitech.navi.data.repositories.CategoryLoader
import com.navitech.navi.utils.Constants.KEY_TAG
import com.parse.FindCallback
import com.parse.ParseQuery

class RemoteCategoryLoader : CategoryLoader {
    override fun loadAll(callback: FindCallback<Category>) {
        val parseQuery: ParseQuery<Category> = ParseQuery.getQuery(Category::class.java)
        parseQuery.addAscendingOrder(KEY_TAG)
        parseQuery.findInBackground(callback)
    }
}
