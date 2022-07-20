package com.navitech.navi.ui.general

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.navitech.navi.R
import com.navitech.navi.ui.NaviActivity
import com.navitech.navi.utils.Constants.KEY_RESULT_VALUE
import org.json.JSONArray
import org.json.JSONObject

class SelectorAdapter(
    private val activity: NaviActivity, private val data: JSONArray, private val type: Int
) : RecyclerView.Adapter<SelectorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_selection, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val json: JSONObject = data.getJSONObject(position)
        val value = json.getString("name")
        if (type == 0) {
            holder.title.text = value
        }
        holder.itemView.setOnClickListener {
            val data = Intent()
            data.putExtra(KEY_RESULT_VALUE, value)
            activity.setResult(RESULT_OK, data)
            activity.finish();
        }
    }

    override fun getItemCount(): Int {
        return data.length()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.item_selection_title)
    }
}