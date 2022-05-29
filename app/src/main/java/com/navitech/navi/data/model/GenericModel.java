package com.navitech.navi.data.model;

import com.parse.ParseObject;
import com.parse.ParseUser;

public class GenericModel extends ParseObject {

    public boolean isEnabled() {
        return getBoolean("enabled");
    }

    public void setEnabled(boolean enabled) {
        put("enabled", enabled);
    }
/*
    public User getCreatedBy() {
        return (ParseUser) getParseObject("createdBy");
    }

    public void setCreatedBy(ParseUser user) {
        put("createdBy", user);
    }

    public String getCreatedById() {
        return getString("createdById");
    }

    public void setCreatedById(String userId) {
        put("createdById", userId);
    }

    public ParseUser getUpdatedBy() {
        return getParseUser("updatedBy");
    }

    public void setUpdatedBy(ParseUser user) {
        put("updatedBy", user);
    }

    public String getUpdatedById() {
        return getString("updatedById");
    }

    public void setUpdatedById(String userId) {
        put("updatedById", userId);
    }
*/
}