package com.navitech.navi.utils

import android.content.Context
import android.content.Intent
import com.navitech.navi.ui.AttractionActivity
import com.navitech.navi.ui.place.PlaceActivity
import com.navitech.navi.ui.main.HomeActivity
import com.navitech.navi.ui.login.LoginActivity
import com.navitech.navi.ui.register.RegisterActivity

class Router {
    companion object {
        fun toLogin(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }

        fun toRegister(context: Context) {
            val intent = Intent(context, RegisterActivity::class.java)
            context.startActivity(intent)
        }

        fun toHome(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }

        fun toPlace(context: Context) {
            val intent = Intent(context, PlaceActivity::class.java)
            context.startActivity(intent)
        }

        fun toAttraction(context: Context) {
            val intent = Intent(context, AttractionActivity::class.java)
            context.startActivity(intent)
        }
    }
}