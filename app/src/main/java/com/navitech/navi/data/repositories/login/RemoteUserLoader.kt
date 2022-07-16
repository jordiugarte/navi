package com.navitech.navi.data.repositories.login

import com.navitech.navi.data.model.users.Account
import com.parse.FindCallback
import com.parse.ParseQuery

class RemoteUserLoader: UserLoader {
    override fun load(username: String, callback: FindCallback<Account>) {
        val parseQuery: ParseQuery<Account> = ParseQuery.getQuery(
            Account::class.java)
        parseQuery.whereEqualTo("username", username)
        parseQuery.findInBackground(callback)
    }
}