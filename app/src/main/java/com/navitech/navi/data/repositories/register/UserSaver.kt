package com.navitech.navi.data.repositories.register

import com.navitech.navi.data.model.users.User
import com.parse.SaveCallback

interface UserSaver {
    fun save(user: User, callback: SaveCallback): User
}