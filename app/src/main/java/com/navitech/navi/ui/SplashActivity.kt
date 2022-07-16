package com.navitech.navi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.navitech.navi.R
import com.navitech.navi.data.local.LocalStorage
import com.navitech.navi.data.repositories.login.CustomLoginCallback
import com.navitech.navi.data.repositories.login.RemoteLogin
import com.navitech.navi.utils.Router

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        if (LocalStorage.getAutoLogin(this)) {
            var email = LocalStorage.getCurrentEmail(this)
            var password = LocalStorage.getCurrentPassword(this)
            if (email != null && password != null) {
                RemoteLogin().login(this, email, password, CustomLoginCallback() { user, e ->
                    if (e == null) {
                        Router.toHome(this)
                    } else {
                        Router.toLogin(this)
                    }
                })
            } else {
                Router.toLogin(this)
            }
        } else {
            Router.toInitial(this)
        }
    }
}