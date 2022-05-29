package com.navitech.navi.ui.login

import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.navitech.navi.R
import com.navitech.navi.data.model.AppActivityController
import com.navitech.navi.data.model.users.User
import com.navitech.navi.utils.LayoutUtils
import com.navitech.navi.utils.Router
import com.parse.LogInCallback

class LoginActivity : AppActivityController() {

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
        LayoutUtils.setToolbar(context)
        userField = findViewById(R.id.login_user_field)
        passwordField = findViewById(R.id.login_password_field)
    }

    fun login(view: View) {
        User.logInInBackground(
            userField.text.toString(),
            passwordField.text.toString(),
            LogInCallback { user, e ->
                if (user != null) {
                    Router.toHome(context)
                } else {

                }
            })
    }
}