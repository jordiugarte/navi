package com.navitech.navi.data.model.users;

import static com.navitech.navi.utils.Constants.KEY_INTERESTS;

import com.navitech.navi.data.model.GenericModel;
import com.navitech.navi.data.model.travel.Category;
import com.parse.ParseClassName;
import com.parse.ParseUser;

import java.io.Serializable;
import java.util.List;

@ParseClassName("preferences")
public class Preferences extends GenericModel implements Serializable {

    public ParseUser getUser() {
        return getParseUser("User");
    }

    public void setUser(Account user) {
        put("User", user);
    }

    public List<Category> getInterests() {
        return getList(KEY_INTERESTS);
    }

    public void setInterests(List<Category> interests) {
        put(KEY_INTERESTS, interests);
    }
}
