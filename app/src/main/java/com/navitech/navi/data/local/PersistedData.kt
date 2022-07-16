package com.navitech.navi.data.local

import com.navitech.navi.data.model.users.Account

class PersistedData {
    companion object {
        var account = Account()
        fun getCurrentAccount(): Account {
            return account
        }

        fun setCurrentAccount(newUser: Account) {
            account = newUser
        }
    }
}