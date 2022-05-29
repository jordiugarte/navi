package com.navitech.navi.data.model.users;

import static com.navitech.navi.utils.Constants.KEY_INTERESTS;
import static com.navitech.navi.utils.Constants.KEY_USER;

import com.navitech.navi.data.model.GenericModel;
import com.navitech.navi.data.model.travel.Category;
import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.Serializable;
import java.util.List;

@ParseClassName("preferences")
public class Preferences extends GenericModel implements Serializable {

    public ParseObject getUser() {
        return getParseObject(KEY_USER);
    }

    public void setUser(User user) {
        put(KEY_USER, user);
    }

    public List<Category> getInterests() {
        return getList(KEY_INTERESTS);
    }

    public void setInterests(List<Category> interests) {
        put(KEY_INTERESTS, interests);
    }
}
