package com.navitech.navi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.navitech.navi.utils.Router

class InitialActivity : AppCompatActivity() {

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