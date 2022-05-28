package com.navitech.navi.ui

import android.app.Application
import com.parse.Parse
import com.parse.ParseObject

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ParseObject.registerSubclass(User::class.java)
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId("YOUR_APP_ID") // if defined
                .clientKey("YOUR_CLIENT_KEY")
                .server("http://localhost:1337/parse/")
                .build()
        )
    }
}