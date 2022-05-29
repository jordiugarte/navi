package com.navitech.navi.data.model.users;

import static com.navitech.navi.utils.Constants.KEY_ADDRESS;
import static com.navitech.navi.utils.Constants.KEY_BIRTH_DATE;
import static com.navitech.navi.utils.Constants.KEY_CITY;
import static com.navitech.navi.utils.Constants.KEY_EMAIL;
import static com.navitech.navi.utils.Constants.KEY_ID_DOCUMENT;
import static com.navitech.navi.utils.Constants.KEY_JOURNEYS;
import static com.navitech.navi.utils.Constants.KEY_LAST_NAME;
import static com.navitech.navi.utils.Constants.KEY_NAME;
import static com.navitech.navi.utils.Constants.KEY_NATIONALITY;
import static com.navitech.navi.utils.Constants.KEY_PHONE;

import com.navitech.navi.data.model.GenericModel;
import com.navitech.navi.data.model.travel.Journey;
import com.parse.ParseClassName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ParseClassName("user")
public class User extends GenericModel implements Serializable {

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
        return getDate("birth_date");
    }

    public void setBirthDate(Date birthDate) {
        put(KEY_BIRTH_DATE, birthDate);
    }

    public String getAddress() {
        return getString("address");
    }

    public void  setAddress(String address) {
        put(KEY_ADDRESS, address);
    }

    public String getEmail() {
        return getString("email");
    }

    public void setEmail(String email) {
        put(KEY_EMAIL, email);
    }

    public String getPhone() {
        return getString("phone");
    }

    public void setPhone(String phone) {
        put(KEY_PHONE, phone);
    }

    public String getNationality() {
        return getString("nationality");
    }

    public void setNationality(String nationality) {
        put(KEY_NATIONALITY, nationality);
    }

    public String getCity() {
        return getString("city");
    }

    public void setCity(String city) {
        put(KEY_CITY, city);
    }

    public String getIdDocument() {
        return getString("id_document");
    }

    public void setIdDocument(String idDocument) {
        put(KEY_ID_DOCUMENT, idDocument);
    }

    public List<Journey> getJourneys() {
        return getList("journeys");
    }

    public void setJourneys(List<Journey> journeys) {
        put(KEY_JOURNEYS, journeys);
    }
}
