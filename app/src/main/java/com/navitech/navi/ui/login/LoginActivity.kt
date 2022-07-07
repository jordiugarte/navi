package com.navitech.navi.ui.login

import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.navitech.navi.R
import com.navitech.navi.data.local.LocalStorage
import com.navitech.navi.data.model.AppActivityController
import com.navitech.navi.data.model.users.User
import com.navitech.navi.utils.*
import com.parse.LogInCallback

class LoginActivity : AppActivityController() {

    private val context = this
    private val TAG = "Login"

    lateinit var userField: EditText
    lateinit var passwordField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.setActivityName(R.string.action_login)
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
        if (validated()) {
            ProgressBarManager.show(context)
            User.logInInBackground(getEmail(), getPassword(), LogInCallback { user, e ->
                ProgressBarManager.hide()
                if (e == null) {
                    LocalStorage.saveLoginData(context, getEmail(), getPassword())
                    Router.toHome(context)
                } else {
                    DialogUtils().showDialog(context, activityName, getString(R.string.error_message_login))
                }
            })
        }
    }

    private fun getEmail(): String {
        return userField.text.toString()
    }

    private fun getPassword(): String {
        return passwordField.text.toString()
    }

    private fun validated(): Boolean {
        if (Validator.email(getEmail())) {
            userField.error = null
        } else {
            userField.error = getString(R.string.error_invalid_email)
            return false
        }
        if (Validator.password(getPassword())) {
            passwordField.error = null
        } else {
            passwordField.error = getString(R.string.error_invalid_password)
            return false
        }
        return true
    }
}