package com.navitech.navi.ui.general

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.navitech.navi.R
import com.navitech.navi.data.local.ParametersData
import com.navitech.navi.ui.NaviActivity
import com.navitech.navi.utils.LayoutUtils
import org.json.JSONArray

class SelectorActivity : NaviActivity() {

    var context: Context = this

    lateinit var recyclerView: RecyclerView
    lateinit var searchField: EditText

    lateinit var data: JSONArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selector)
        LayoutUtils.setToolbar(this, getString(R.string.action_select_an_option))
        initViews()
        setData()
    }

    private fun initViews() {
        recyclerView =
            LayoutUtils.setRecyclerView(this, R.id.recycler_list_selector, LinearLayout.VERTICAL)
        searchField = findViewById(R.id.search_field)
    }

    fun setData() {
        data = ParametersData().getCountries(context)
        recyclerView.adapter = SelectorAdapter(this, data, 0)
    }

    //TODO search field
}