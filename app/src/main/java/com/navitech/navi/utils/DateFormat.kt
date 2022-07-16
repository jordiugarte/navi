package com.navitech.navi.utils

import java.text.SimpleDateFormat
import java.util.*

object DateFormat {

    private val FORMAT_DEFAULT: String = "dd/MM/yyyy"

    fun stringToDate(s: String) : Date {
        return SimpleDateFormat(FORMAT_DEFAULT).parse(s);
    }
}