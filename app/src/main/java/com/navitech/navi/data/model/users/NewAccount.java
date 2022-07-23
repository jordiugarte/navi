package com.navitech.navi.data.model.users;

public class NewAccount {
    private final String username;
    private final String email;
    private final String password;
    private final Account account;

    public NewAccount(String username, String email, String password, Account account) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Account getAccount() {
        return account;
    }
}
