package com.navitech.navi.data.repositories.login

import com.navitech.navi.data.model.users.Account
import com.parse.FindCallback

interface UserLoader {
    fun load(id: String, callback: FindCallback<Account>)
}