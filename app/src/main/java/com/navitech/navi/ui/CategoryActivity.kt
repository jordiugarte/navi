package com.navitech.navi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.navitech.navi.R
import com.navitech.navi.data.model.attractions.Category
import com.navitech.navi.utils.Constants.KEY_CATEGORY

class CategoryActivity : AppCompatActivity() {
    lateinit var category: Category

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        retrieveData()
    }

    private fun retrieveData() {
        val bundle = intent.extras
        if (bundle != null) {
            category = bundle.getSerializable(KEY_CATEGORY) as Category
        }
    }
}