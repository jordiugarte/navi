package com.navitech.navi.ui

import android.app.Application
import com.navitech.navi.data.model.travel.Attraction
import com.navitech.navi.data.model.travel.Category
import com.navitech.navi.data.model.travel.Journey
import com.navitech.navi.data.model.users.Preferences
import com.navitech.navi.data.model.users.Account
import com.parse.Parse
import com.parse.ParseObject

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ParseObject.registerSubclass(Account::class.java)
        ParseObject.registerSubclass(Attraction::class.java)
        ParseObject.registerSubclass(Journey::class.java)
        ParseObject.registerSubclass(Category::class.java)
        ParseObject.registerSubclass(Preferences::class.java)
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId("Wr4wdvm3IWenL6u57G44OrTZD5OLTO7f9SXCSLMI")
                .clientKey("WTwI93veGQ1DyJcR89rboYV3O9RIFC7lLUDHSVS5")
                .server("https://pg-app-2ro1edddvpndld0jjxh5e2g4cfhd0f.scalabl.cloud/1/")
                .build()
        )
    }
}