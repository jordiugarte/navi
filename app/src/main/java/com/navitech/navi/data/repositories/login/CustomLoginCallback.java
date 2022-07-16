package com.navitech.navi.data.repositories.login;

import com.navitech.navi.data.model.users.Account;

public interface CustomLoginCallback {
    void done(Account user, Exception e);
}
