package com.navitech.navi.data.repositories.register

import com.navitech.navi.data.model.users.User
import com.parse.SaveCallback

class RemoteUserSaver : UserSaver {
    override fun save(user: User, callback: SaveCallback): User {
        user.saveInBackground(callback)
        return user
    }
}