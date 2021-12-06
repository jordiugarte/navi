package com.domain.project.utils

import android.content.Context
import android.content.Intent
import com.domain.project.LoginActivity

class Router {
    companion object {
        fun toLogin(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }
}