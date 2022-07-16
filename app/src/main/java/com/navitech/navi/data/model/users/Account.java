package com.navitech.navi.data.model.users;

import static com.navitech.navi.utils.Constants.KEY_ADDRESS;
import static com.navitech.navi.utils.Constants.KEY_AGENCY;
import static com.navitech.navi.utils.Constants.KEY_BIOGRAPHY;
import static com.navitech.navi.utils.Constants.KEY_BIRTH_DATE;
import static com.navitech.navi.utils.Constants.KEY_CITY;
import static com.navitech.navi.utils.Constants.KEY_COUNTRY;
import static com.navitech.navi.utils.Constants.KEY_CURRENT_PASSWORD;
import static com.navitech.navi.utils.Constants.KEY_EMAIL;
import static com.navitech.navi.utils.Constants.KEY_FOUNDATION_DATE;
import static com.navitech.navi.utils.Constants.KEY_ID_DOCUMENT;
import static com.navitech.navi.utils.Constants.KEY_JOURNEYS;
import static com.navitech.navi.utils.Constants.KEY_LAST_NAME;
import static com.navitech.navi.utils.Constants.KEY_NAME;
import static com.navitech.navi.utils.Constants.KEY_PHONE;
import static com.navitech.navi.utils.Constants.KEY_PICTURE;
import static com.navitech.navi.utils.Constants.KEY_TYPE;
import static com.navitech.navi.utils.Constants.KEY_USER_NAME;
import static com.navitech.navi.utils.Constants.KEY_PASSWORD;

import com.navitech.navi.data.model.travel.Journey;
import com.parse.ParseClassName;
import com.parse.ParseObject;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ParseClassName("account")
public class Account extends ParseObject implements Serializable {

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

    public Date getFoundationDate() {
        return getDate(KEY_FOUNDATION_DATE);
    }

    public void setFoundationDate(Date date) {
        put(KEY_FOUNDATION_DATE, date);
    }

    public String getAddress() {
        return getString(KEY_ADDRESS);
    }

    public void  setAddress(String address) {
        put(KEY_ADDRESS, address);
    }

    public void  setPicture(String photo) {
        put(KEY_PICTURE, photo);
    }

    public String getPicture() {
        return getString(KEY_PICTURE);
    }

    public void setBiography(String biography) {
        put(KEY_BIOGRAPHY, biography);
    }

    public String getBiography() {
        return getString(KEY_BIOGRAPHY);
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

    public String getAgency() {
        return getString(KEY_AGENCY);
    }

    public void setAgency(String agency) {
        put(KEY_AGENCY, agency);
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

    public Boolean getType() {
        return getBoolean(KEY_TYPE);
    }

    public void setType(Boolean type) {
        put(KEY_TYPE, type);
    }

    public Account(){}

    public Account(String username, String names, String lastNames, Date birthDate, String address, String email, String phone, String country, String city, String idDocument) {
        setUsername(username);
        setName(names);
        setLastName(lastNames);
        setBirthDate(birthDate);
        setAddress(address);
        setEmail(email);
        setPhone(phone);
        setCountry(country);
        setCity(city);
        setIdDocument(idDocument);
        setType(true);
    }

    public Account(String username, String names, String lastNames, Date birthDate, String address, String email, String phone, String country, String city, String idDocument, String agency, Date foundationDate) {
        setUsername(username);
        setName(names);
        setLastName(lastNames);
        setBirthDate(birthDate);
        setEmail(email);
        setPhone(phone);
        setCountry(country);
        setCity(city);
        setIdDocument(idDocument);
        setAgency(agency);
        setFoundationDate(foundationDate);
        setType(false);
    }
}
