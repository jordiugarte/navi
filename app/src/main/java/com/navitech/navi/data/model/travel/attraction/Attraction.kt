package com.navitech.navi.data.model.travel.attraction

import com.navitech.navi.data.model.GenericModel
import com.navitech.navi.data.model.travel.Category
import com.navitech.navi.utils.Constants
import com.parse.ParseClassName
import com.parse.ParseGeoPoint
import java.io.Serializable

@ParseClassName("attraction")
class Attraction() : GenericModel(), Serializable {

    var name: String
        get() = getString(Constants.KEY_NAME)
        set(name) {
            put(Constants.KEY_NAME, name)
        }
    var description: String
        get() = getString(Constants.KEY_DESCRIPTION)
        set(name) {
            put(Constants.KEY_DESCRIPTION, name)
        }
    var price: Int
        get() = getInt(Constants.KEY_PRICE)
        set(name) {
            put(Constants.KEY_PRICE, name)
        }
    var country: String
        get() = getString(Constants.KEY_COUNTRY)
        set(name) {
            put(Constants.KEY_COUNTRY, name)
        }
    var city: String
        get() = getString(Constants.KEY_CITY)
        set(name) {
            put(Constants.KEY_CITY, name)
        }
    var location: ParseGeoPoint
        get() = getParseGeoPoint(Constants.KEY_LOCATION)
        set(value) {
            put(Constants.KEY_LOCATION, value)
        }
    var rating: Double
        get() = getDouble(Constants.KEY_RATING)
        set(value) {
            put(Constants.KEY_RATING, value)
        }
    var categories: ArrayList<Int>
        get() = get("categories") as ArrayList<Int>
        set(value) {
            put("categories", value)
        }

    var photos: ArrayList<String>
        get() = get(Constants.KEY_PHOTOS) as ArrayList<String>
        set(value) {
            put(Constants.KEY_PHOTOS, value)
        }
}