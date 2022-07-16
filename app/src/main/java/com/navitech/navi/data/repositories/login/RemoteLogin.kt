package com.navitech.navi.data.repositories.login

import android.content.Context
import com.navitech.navi.data.local.LocalStorage
import com.navitech.navi.data.local.PersistedData
import com.parse.ParseUser
import java.lang.Exception

class RemoteLogin : LoginService {
    override fun login(
        context: Context,
        email: String,
        password: String,
        callback: CustomLoginCallback
    ) {
        ParseUser.logInInBackground(email, password) { user, e ->
            if (e == null) {
                RemoteUserLoader().load(user.username) { objects, e ->
                    if (e == null) {
                        if (objects.size > 0) {
                            val account = objects[0]
                            PersistedData.setCurrentAccount(account)
                            LocalStorage.saveLoginData(context, email, password)
                            callback.done(account, null)
                        } else {
                            callback.done(null, Exception("User not found"))
                        }
                    } else {
                        callback.done(null, null)
                    }
                }
            }
        }
    }
}