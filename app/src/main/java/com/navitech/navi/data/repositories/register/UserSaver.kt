package com.navitech.navi.data.repositories.register

import com.navitech.navi.data.model.users.Account
import com.parse.SaveCallback

interface UserSaver {
    fun save(user: Account, callback: SaveCallback): Account
}