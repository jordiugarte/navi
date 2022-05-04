package com.navitech.navi.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.navitech.navi.R
import com.navitech.navi.utils.Router

class LoginActivity : AppCompatActivity() {

    private val context = this
    private val TAG = "Login"

    lateinit var userField: EditText
    lateinit var passwordField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
    }

    private fun initViews() {
        userField = findViewById(R.id.login_user_field)
        passwordField = findViewById(R.id.login_password_field)
    }

    fun login(view: View) {
        Router.toHome(context)
    }
}