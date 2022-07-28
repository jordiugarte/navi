package com.navitech.navi.utils

object Constants {

    val API_URL = ""

    //  Permissions request codes
    val LOCATION_REQUEST_CODE = 100

    //  Keys
    @JvmField val KEY_USER_NAME: String = "username"
    @JvmField val KEY_PASSWORD: String = "password"
    @JvmField val KEY_NAME: String = "name"
    @JvmField val KEY_LAST_NAME: String = "last_name"
    @JvmField val KEY_BIRTH_DATE: String = "birth_date"
    @JvmField val KEY_FOUNDATION_DATE: String = "foundation_date"
    @JvmField val KEY_ADDRESS: String = "address"
    @JvmField val KEY_EMAIL: String = "email"
    @JvmField val KEY_PHONE: String = "phone"
    @JvmField val KEY_NATIONALITY: String = "nationality"
    @JvmField val KEY_CITY: String = "city"
    @JvmField val KEY_AGENCY: String = "agency"
    @JvmField val KEY_TYPE: String = "type"
    @JvmField val KEY_COUNTRY: String = "country"
    @JvmField val KEY_CURRENCY: String = "currency"
    @JvmField val KEY_ID_DOCUMENT: String = "id_document"
    @JvmField val KEY_JOURNEYS: String = "journeys"
    @JvmField val KEY_DESCRIPTION: String = "description"
    @JvmField val KEY_ATTRACTION: String = "attraction"
    @JvmField val KEY_TAG: String = "tag"
    @JvmField val KEY_CATEGORY: String = "category"
    @JvmField val KEY_LATITUDE: String = "latitude"
    @JvmField val KEY_LONGITUDE: String = "longitude"
    @JvmField val KEY_START_DATE: String = "start_date"
    @JvmField val KEY_CREATED_AT: String = "createdAt"
    @JvmField val KEY_END_DATE: String = "end_date"
    @JvmField val KEY_PARTICIPANTS: String = "participants"
    @JvmField val KEY_SUB_TOTAL: String = "sub_total"
    @JvmField val KEY_INTERESTS: String = "interests"
    @JvmField val KEY_PICTURE: String = "picture"
    @JvmField val KEY_BIOGRAPHY: String = "biography"
    @JvmField val KEY_RESULT_VALUE: String = "result_value"
    @JvmField val KEY_LOCATION: String = "location"
    @JvmField val KEY_RATING: String = "rating"
    @JvmField val KEY_PRICE: String = "price"
    @JvmField val KEY_PHOTOS: String = "photos"
    @JvmField val KEY_IMAGE: String = "image"

    const val KEY_SHARED_PREFS = "shared preferences"
    const val KEY_CURRENT_EMAIL = "current email"
    const val KEY_CURRENT_PASSWORD = "current password"
    const val KEY_AUTO_LOGIN = "auto login"

    //  Request codes
    const val REQUEST_CODE_COUNTRY = 0

    fun LOCATIONS(): ArrayList<String> {
        val locations = arrayListOf<String>()
        locations.add("countries.json")
        return locations
    }
}
