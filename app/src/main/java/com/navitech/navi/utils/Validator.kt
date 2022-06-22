package com.navitech.navi.utils

object Validator {

    private val REGEX_NAMES = "/^[a-z ,.'-]+\$/i".toRegex()
    private val REGEX_NUMBER = "^\\d{10}$".toRegex()
    private val REGEX_EMAIL = "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])\n".toRegex()
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