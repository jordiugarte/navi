package com.navitech.navi.data.repositories.attraction

import com.navitech.navi.data.model.travel.attraction.Attraction
import com.navitech.navi.utils.Constants
import com.navitech.navi.utils.Constants.KEY_CITY
import com.navitech.navi.utils.Constants.KEY_COUNTRY
import com.parse.FindCallback
import com.parse.ParseQuery

class RemoteAttractionLoader : AttractionLoader {
    override fun loadAll(callback: FindCallback<Attraction>) {
        val parseQuery: ParseQuery<Attraction> = ParseQuery.getQuery(Attraction::class.java)
        parseQuery.addAscendingOrder(Constants.KEY_CREATED_AT)
        parseQuery.findInBackground(callback)
    }

    override fun loadByCity(city: String, callback: FindCallback<Attraction>) {
        val parseQuery: ParseQuery<Attraction> = ParseQuery.getQuery(Attraction::class.java)
        parseQuery.addAscendingOrder(Constants.KEY_CREATED_AT)
        parseQuery.whereEqualTo(KEY_CITY, city)
        parseQuery.findInBackground(callback)
    }

    override fun loadByCountry(country: String, callback: FindCallback<Attraction>) {
        val parseQuery: ParseQuery<Attraction> = ParseQuery.getQuery(Attraction::class.java)
        parseQuery.addAscendingOrder(Constants.KEY_CREATED_AT)
        parseQuery.whereEqualTo(KEY_COUNTRY, country)
        parseQuery.findInBackground(callback)
    }
}