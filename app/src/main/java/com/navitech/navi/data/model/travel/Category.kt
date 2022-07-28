package com.navitech.navi.data.model.travel

import com.navitech.navi.data.model.GenericModel
import com.navitech.navi.utils.Constants.KEY_DESCRIPTION
import com.navitech.navi.utils.Constants.KEY_NAME
import com.navitech.navi.utils.Constants.KEY_TAG
import com.parse.ParseClassName
import java.io.Serializable

@ParseClassName("category")
class Category() : GenericModel(), Serializable {
    var name: String
        get() = getString(KEY_NAME)
        set(name) {
            put(KEY_NAME, name)
        }
    var description: String
        get() = getString(KEY_DESCRIPTION)
        set(name) {
            put(KEY_DESCRIPTION, name)
        }
    var tag: Int
        get() = getInt(KEY_TAG)
        set(tag) {
            put(KEY_TAG, tag)
        }
}