package com.navitech.navi.data.repositories.attraction

import com.navitech.navi.data.model.travel.attraction.Attraction
import com.parse.FindCallback

interface AttractionLoader {
    fun loadAll(callback: FindCallback<Attraction>)

    fun loadByCity(city: String, callback: FindCallback<Attraction>)

    fun loadByCountry(country: String, callback: FindCallback<Attraction>)
}