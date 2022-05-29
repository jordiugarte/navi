package com.navitech.navi.data.model.travel;

import static com.navitech.navi.utils.Constants.KEY_CATEGORY;
import static com.navitech.navi.utils.Constants.KEY_CITY;
import static com.navitech.navi.utils.Constants.KEY_COUNTRY;
import static com.navitech.navi.utils.Constants.KEY_CURRENCY;
import static com.navitech.navi.utils.Constants.KEY_LATITUDE;
import static com.navitech.navi.utils.Constants.KEY_LONGITUDE;
import static com.navitech.navi.utils.Constants.KEY_NAME;

import com.navitech.navi.data.model.GenericModel;
import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.Serializable;

@ParseClassName("attraction")
public class Attraction extends GenericModel implements Serializable {

    public String getName() {
        return getString(KEY_NAME);
    }

    public void setName(String name) {
        put(KEY_NAME, name);
    }

    public String getLatitude() {
        return getString(KEY_LATITUDE);
    }

    public void setLatitude(String name) {
        put(KEY_LATITUDE, name);
    }

    public String getLongitude() {
        return getString(KEY_LONGITUDE);
    }

    public void setLongitude(String name) {
        put(KEY_LONGITUDE, name);
    }

    public ParseObject getCategory() {
        return getParseObject(KEY_CATEGORY);
    }

    public void setCategory(Category category) {
        put(KEY_CATEGORY, category);
    }

    public String getCity() {
        return getString(KEY_CITY);
    }

    public void setCity(String city) {
        put(KEY_CITY, city);
    }

    public String country() {
        return getString(KEY_COUNTRY);
    }

    public void setCountry(String country) {
        put(KEY_COUNTRY, country);
    }

    public String getCurrency() {
        return getString(KEY_CURRENCY);
    }

    public void setCurrency(String currency) {
        put(KEY_CURRENCY, currency);
    }
}
