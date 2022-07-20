package com.navitech.navi.utils

object Validator {

    private val REGEX_NAMES = "^[a-zA-Z\\\\s]+".toRegex()
    private val REGEX_NUMBER = "[0-9]+".toRegex()
    private val REGEX_EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$".toRegex()
    private val REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}".toRegex()


    fun notEmpty(s: String): Boolean {
        return s.isNotEmpty()
    }

    fun names(s: String): Boolean {
        return REGEX_NAMES.matches(s)
    }

    fun phone(s: String): Boolean {
        return REGEX_NUMBER.matches(s)
    }

    fun email(s: String): Boolean {
        return REGEX_EMAIL.matches(s)
    }

    fun password(s: String): Boolean {
        return REGEX_PASSWORD.matches(s)
    }
}