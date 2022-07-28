package com.navitech.navi.ui.main

import android.os.Bundle
import android.view.View
import com.navitech.navi.R
import com.navitech.navi.ui.NaviActivity
import com.navitech.navi.utils.Router

class InitialActivity : NaviActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)
    }

    fun goToLogin(view: View) {
        Router.toLogin(this)
    }

    fun goToRegister(view: View) {
        Router.toRegister(this)
    }
}