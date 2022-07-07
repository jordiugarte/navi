package com.navitech.navi.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE

import android.content.SharedPreferences
import com.navitech.navi.utils.Constants.KEY_AUTO_LOGIN
import com.navitech.navi.utils.Constants.KEY_CURRENT_EMAIL
import com.navitech.navi.utils.Constants.KEY_CURRENT_PASSWORD
import com.navitech.navi.utils.Constants.KEY_SHARED_PREFS

object LocalStorage {
    private fun sharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(KEY_SHARED_PREFS, MODE_PRIVATE)
    }

    fun editor(context: Context): SharedPreferences.Editor {
        return sharedPreferences(context).edit()
    }

    fun saveLoginData(context: Context, email: String, password: String) {
        setCurrentEmail(context, email)
        setCurrentPassword(context, password)
        setAutoLogin(context, true)
    }

    fun removeLoginData(context: Context, email: String, password: String) {
        setCurrentEmail(context, "")
        setCurrentPassword(context, "")
        setAutoLogin(context, false)
    }

    fun setCurrentEmail(context: Context, email: String) {
        var editor = editor(context)
        editor.putString(KEY_CURRENT_EMAIL, email)
        editor.apply()
        editor.commit()
    }

    fun setCurrentPassword(context: Context, password: String) {
        var editor = editor(context)
        editor.putString(KEY_CURRENT_PASSWORD, password)
        editor.apply()
        editor.commit()
    }

    fun setAutoLogin(context: Context, autoLogin: Boolean) {
        var editor = editor(context)
        editor.putBoolean(KEY_AUTO_LOGIN, autoLogin)
        editor.apply()
        editor.commit()
    }

    fun getAutoLogin(context: Context): Boolean {
        return sharedPreferences(context).getBoolean(KEY_AUTO_LOGIN, false)
    }

    fun getCurrentEmail(context: Context): String? {
        return sharedPreferences(context).getString(KEY_CURRENT_EMAIL, "")
    }

    fun getCurrentPassword(context: Context): String? {
        return sharedPreferences(context).getString(KEY_CURRENT_PASSWORD, "")
    }
}