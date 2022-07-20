package com.navitech.navi.utils

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateFormat {

    enum class FORMAT_TYPE {
        FORMAT_DEFAULT,
        SALE_END_DATE,
        ONLY_TIME,
        ONLY_PRETTY_DATE
    }

    fun stringToDate(s: String, type: FORMAT_TYPE): Date {
        return formatType(type).parse(s);
    }

    fun dateInts(timeStamp: Long): IntArray {
        val date = Date(timeStamp)
        val calendar = Calendar.getInstance()
        calendar.time = date
        return intArrayOf(
            calendar[Calendar.YEAR],
            calendar[Calendar.MONTH],
            calendar[Calendar.DAY_OF_MONTH]
        )
    }

    fun dateToString(date: Long, type: FORMAT_TYPE): String {
        return dateToString(Date(date), type)
    }

    fun dateToString(date: Date, type: FORMAT_TYPE): String {
        return formatType(type).format(date)
    }

    fun dateConcat(date: String): Date {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        return try {
            dateFormat.parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
            Date()
        }
    }

    fun formatType(type: FORMAT_TYPE): SimpleDateFormat {
        return when (type) {
            FORMAT_TYPE.FORMAT_DEFAULT -> SimpleDateFormat("dd/MM/yyyy")
            FORMAT_TYPE.SALE_END_DATE -> SimpleDateFormat("dd/MM @ hh:mm")
            FORMAT_TYPE.ONLY_TIME -> SimpleDateFormat("hh:mm aa")
            FORMAT_TYPE.ONLY_PRETTY_DATE -> SimpleDateFormat("MMM dd, yyyy")
            else -> SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        }
    }

    fun dateFromParams(y: Int, m: Int, d: Int): Date {
        var dateString = ""
        dateString += if (d > 9) "$d" else "0$d"
        dateString += "/"
        val month = m + 1
        dateString += if (month + 1 > 9)  "$month" else "0$month"
        dateString += "/"
        dateString += y
        return stringToDate(dateString, FORMAT_TYPE.FORMAT_DEFAULT)
    }
}