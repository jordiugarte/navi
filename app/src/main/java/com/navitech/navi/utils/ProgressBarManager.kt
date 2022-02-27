package com.navitech.navi.utils

import android.app.Activity
import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.navitech.navi.R
import java.lang.Exception

object ProgressBarManager {
    var progressDialog: ProgressDialog? = null
    fun show(context: Activity) {
        hide()
        var progressDialog = ProgressDialog(context)
        progressDialog = ProgressDialog.show(
            context,
            context.resources.getString(R.string.action_wait),
            context.resources.getString(R.string.action_processing)
        )
        progressDialog.setContentView(R.layout.item_progress_bar)
        progressDialog.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog.setCancelable(false)
        try {
            progressDialog.show()
        } catch (e: Exception) {
            Log.e("Message", "error$e")
        }
    }

    fun showSuccessToast(context: Activity, message: String?) {
        val li: LayoutInflater = context.getLayoutInflater()
        val layout: View = li.inflate(
            R.layout.success_progress_bar,
            context.findViewById(R.id.success_progress_bar) as ViewGroup
        )
        val messageTextView = layout.findViewById<TextView>(R.id.text_loading_services)
        messageTextView.text = message
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.setView(layout)
        toast.show()
    }

    fun showErrorToast(context: Activity, message: String?) {
        val li: LayoutInflater = context.getLayoutInflater()
        val layout: View = li.inflate(
            R.layout.error_progress_bar,
            context.findViewById(R.id.error_progress_bar) as ViewGroup
        )
        val messageTextView = layout.findViewById<TextView>(R.id.text_loading_services)
        messageTextView.text = message
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.setView(layout)
        toast.show()
    }

    fun hide() {
        if (progressDialog != null) {
            progressDialog!!.dismiss()
        }
    }
}
