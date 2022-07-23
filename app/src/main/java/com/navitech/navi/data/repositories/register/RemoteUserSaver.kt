package com.navitech.navi.data.repositories.register

import com.navitech.navi.data.model.users.NewAccount
import com.parse.ParseUser
import com.parse.SaveCallback

class RemoteUserSaver : UserSaver {
    override fun save(newAccount: NewAccount, callback: SaveCallback) {
        val parseUser = ParseUser()
        parseUser.username = newAccount.username
        parseUser.email = newAccount.email
        parseUser.setPassword(newAccount.password)
        parseUser.signUpInBackground() {
            if (it == null) {
                newAccount.account.saveInBackground { e ->
                    if (e == null) {
                        callback.done(null)
                    } else {
                        callback.done(e)
                    }
                }
            } else {
                callback.done(it)
            }
        }
    }
}