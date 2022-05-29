package com.navitech.navi.data.model.users;

import static com.navitech.navi.utils.Constants.KEY_ADDRESS;
import static com.navitech.navi.utils.Constants.KEY_BIRTH_DATE;
import static com.navitech.navi.utils.Constants.KEY_CITY;
import static com.navitech.navi.utils.Constants.KEY_COUNTRY;
import static com.navitech.navi.utils.Constants.KEY_EMAIL;
import static com.navitech.navi.utils.Constants.KEY_ID_DOCUMENT;
import static com.navitech.navi.utils.Constants.KEY_JOURNEYS;
import static com.navitech.navi.utils.Constants.KEY_LAST_NAME;
import static com.navitech.navi.utils.Constants.KEY_NAME;
import static com.navitech.navi.utils.Constants.KEY_NATIONALITY;
import static com.navitech.navi.utils.Constants.KEY_PHONE;
import static com.navitech.navi.utils.Constants.KEY_USER_NAME;

import com.navitech.navi.data.model.GenericModel;
import com.navitech.navi.data.model.travel.Journey;
import com.parse.ParseClassName;
import com.parse.ParseUser;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ParseClassName("User")
public class User extends ParseUser implements Serializable {

    public String getUsername() {
        return getString(KEY_USER_NAME);
    }

    public void setUsername(String username) {
        put(KEY_USER_NAME, username);
    }

    public String getName() {
        return getString(KEY_NAME);
    }

    public void setName(String name) {
        put(KEY_NAME, name);
    }

    public String getLastName() {
        return getString(KEY_LAST_NAME);
    }

    public void setLastName(String lastName) {
        put(KEY_LAST_NAME, lastName);
    }

    public Date getBirthDate() {
        return getDate(KEY_BIRTH_DATE);
    }

    public void setBirthDate(Date birthDate) {
        put(KEY_BIRTH_DATE, birthDate);
    }

    public String getAddress() {
        return getString(KEY_ADDRESS);
    }

    public void  setAddress(String address) {
        put(KEY_ADDRESS, address);
    }

    public String getEmail() {
        return getString(KEY_EMAIL);
    }

    public void setEmail(String email) {
        put(KEY_EMAIL, email);
    }

    public String getPhone() {
        return getString(KEY_PHONE);
    }

    public void setPhone(String phone) {
        put(KEY_PHONE, phone);
    }

    public String getCountry() {
        return getString(KEY_COUNTRY);
    }

    public void setCountry(String country) {
        put(KEY_COUNTRY, country);
    }

    public String getCity() {
        return getString(KEY_CITY);
    }

    public void setCity(String city) {
        put(KEY_CITY, city);
    }

    public String getIdDocument() {
        return getString(KEY_ID_DOCUMENT);
    }

    public void setIdDocument(String idDocument) {
        put(KEY_ID_DOCUMENT, idDocument);
    }

    public List<Journey> getJourneys() {
        return getList(KEY_JOURNEYS);
    }

    public void setJourneys(List<Journey> journeys) {
        put(KEY_JOURNEYS, journeys);
    }
}
