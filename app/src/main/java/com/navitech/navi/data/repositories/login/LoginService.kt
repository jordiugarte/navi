package com.navitech.navi.data.repositories.login

import android.content.Context

interface LoginService {
    fun login(context: Context, email: String, password: String, callback: CustomLoginCallback)
}