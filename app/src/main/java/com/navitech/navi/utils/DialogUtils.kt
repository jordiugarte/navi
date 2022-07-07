package com.navitech.navi.utils

import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.DialogInterface
import com.navitech.navi.R
import java.util.*
import java.util.concurrent.TimeUnit

class DialogUtils {
    fun showDialog(context: Activity, title: String?, message: String?) {
        AlertDialog.Builder(context, R.style.dialog_theme)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                context.getText(R.string.action_accept)
            ) { dialog: DialogInterface, which: Int -> dialog.dismiss() }
            .show()
    }

    fun showDialog(
        context: Activity,
        title: String?,
        message: String?,
        listener: DialogInterface.OnClickListener?
    ) {
        AlertDialog.Builder(context, R.style.dialog_theme)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(context.getText(R.string.action_accept), listener)
            .show()
    }

    fun showYesNoDialog(
        context: Activity,
        title: String?,
        message: String?,
        listener: DialogInterface.OnClickListener?
    ) {
        AlertDialog.Builder(context, R.style.dialog_theme)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(context.getText(R.string.action_accept), listener)
            .setNegativeButton(
                context.getText(R.string.action_cancel)
            ) { dialog: DialogInterface, which: Int -> dialog.dismiss() }
            .show()
    }

    /*fun showDatePicker(context: Activity?, currentDate: Long, dateListener: OnDateSetListener?) {
        val y: Int = DateFormats.dateInts(currentDate).get(0)
        val m: Int = DateFormats.dateInts(currentDate).get(1)
        val d: Int = DateFormats.dateInts(currentDate).get(2)
        val datePicker = DatePickerDialog(
            context!!, R.style.MyDialogTheme, dateListener, y, m, d
        )
        datePicker.datePicker.minDate = System.currentTimeMillis()
        datePicker.show()
    }

    fun showDatePicker(
        context: Activity?,
        currentDate: Long,
        minDate: Long,
        dateListener: OnDateSetListener?
    ) {
        val datePicker = DatePickerDialog(
            context!!,
            R.style.MyDialogTheme,
            dateListener,
            DateFormats.dateInts(currentDate).get(0),
            DateFormats.dateInts(currentDate).get(1),
            DateFormats.dateInts(currentDate).get(2)
        )
        datePicker.datePicker.minDate = minDate + TimeUnit.DAYS.toMillis(1)
        datePicker.datePicker.maxDate = minDate + TimeUnit.DAYS.toMillis(31)
        datePicker.show()
    }

    fun showTimePicker(context: Activity?, date: Long, timeListener: OnTimeSetListener?) {
        val mHour = Date(date).hours
        val mMinute = Date(date).minutes
        val timePickerDialog = TimePickerDialog(
            context, R.style.MyDialogTheme,
            timeListener,
            mHour,
            mMinute,
            true
        )
        timePickerDialog.setOnCancelListener { dialogInterface: DialogInterface -> dialogInterface.dismiss() }
        timePickerDialog.show()
    }*/
}