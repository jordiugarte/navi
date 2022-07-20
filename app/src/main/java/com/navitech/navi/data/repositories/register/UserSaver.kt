package com.navitech.navi.data.repositories.register

import com.navitech.navi.data.model.users.NewAccount
import com.parse.SaveCallback

interface UserSaver {
    fun save(newAccount: NewAccount, callback: SaveCallback)
}