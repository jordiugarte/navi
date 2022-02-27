package com.navitech.navi.utils

import android.content.Context
import android.content.Intent
import com.navitech.navi.ui.home.HomeActivity
import com.navitech.navi.ui.login.LoginActivity

class Router {
    companion object {
        fun toLogin(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }

        fun toHome(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }
}