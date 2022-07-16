package com.navitech.navi.data.repositories.register

import com.navitech.navi.data.model.users.Account
import com.parse.SaveCallback

class RemoteUserSaver : UserSaver {
    override fun save(user: Account, callback: SaveCallback): Account {
        user.saveInBackground(callback)
        return user
    }
}