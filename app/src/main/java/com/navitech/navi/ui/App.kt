package com.navitech.navi.ui

import android.app.Application
import com.navitech.navi.data.model.travel.Attraction
import com.navitech.navi.data.model.travel.Category
import com.navitech.navi.data.model.travel.Journey
import com.navitech.navi.data.model.users.Preferences
import com.navitech.navi.data.model.users.User
import com.parse.Parse
import com.parse.ParseObject

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ParseObject.registerSubclass(User::class.java)
        ParseObject.registerSubclass(Attraction::class.java)
        ParseObject.registerSubclass(Journey::class.java)
        ParseObject.registerSubclass(Category::class.java)
        ParseObject.registerSubclass(Preferences::class.java)
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId("YOUR_APP_ID") // if defined
                .clientKey("YOUR_CLIENT_KEY")
                .server("http://localhost:1337/parse/")
                .build()
        )
    }
}