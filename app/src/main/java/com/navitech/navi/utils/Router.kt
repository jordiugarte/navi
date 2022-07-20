package com.navitech.navi.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import com.navitech.navi.data.model.travel.Category
import com.navitech.navi.ui.attraction.AttractionActivity
import com.navitech.navi.ui.attraction.CategoryActivity
import com.navitech.navi.ui.general.SelectorActivity
import com.navitech.navi.ui.login.LoginActivity
import com.navitech.navi.ui.main.HomeActivity
import com.navitech.navi.ui.main.InitialActivity
import com.navitech.navi.ui.place.PlaceActivity
import com.navitech.navi.ui.register.RegisterActivity
import com.navitech.navi.utils.Constants.KEY_CATEGORY
import com.navitech.navi.utils.Constants.REQUEST_CODE_COUNTRY

class Router {
    companion object {
        fun toInitial(context: Context) {
            val intent = Intent(context, InitialActivity::class.java)
            context.startActivity(intent)
        }

        fun toLogin(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }

        fun toRegister(context: Context) {
            val intent = Intent(context, RegisterActivity::class.java)
            context.startActivity(intent)
        }

        fun toHome(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }

        fun toPlace(context: Context) {
            val intent = Intent(context, PlaceActivity::class.java)
            context.startActivity(intent)
        }

        fun toAttraction(context: Context) {
            val intent = Intent(context, AttractionActivity::class.java)
            context.startActivity(intent)
        }

        fun toCategory(context: Context, category: Category) {
            val intent = Intent(context, CategoryActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(KEY_CATEGORY, category)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }

        fun toCountries(context: Activity, response: ActivityResultLauncher<Intent>) {
            val intent = Intent(context, SelectorActivity::class.java)
            response.launch(intent)
        }
    }
}