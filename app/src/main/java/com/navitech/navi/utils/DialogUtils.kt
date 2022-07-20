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

    fun pickBornDatePicker(
        context: Activity,
        listener: OnDateSetListener
    ) {
        showDatePicker(
            context,
            System.currentTimeMillis() - 568080000000L - 86400000L,
            System.currentTimeMillis() - 568080000000L,
            listener
        )
    }

    fun showDatePicker(
        context: Activity,
        currentDate: Long,
        minDate: Long,
        maxDate: Long,
        listener: OnDateSetListener
    ) {
        val y = DateFormat.dateInts(currentDate)[0];
        val m = DateFormat.dateInts(currentDate)[1];
        val d = DateFormat.dateInts(currentDate)[2];
        val datePicker: DatePickerDialog = DatePickerDialog(
            context, R.style.dialog_theme, listener, y, m, d
        );
        datePicker.getDatePicker().minDate = minDate
        datePicker.getDatePicker().maxDate = maxDate
        datePicker.show();
    }

    fun showDatePicker(
        context: Activity,
        currentDate: Long,
        maxDate: Long,
        listener: OnDateSetListener
    ) {
        val y = DateFormat.dateInts(currentDate)[0];
        val m = DateFormat.dateInts(currentDate)[1];
        val d = DateFormat.dateInts(currentDate)[2];
        val datePicker = DatePickerDialog(
            context, R.style.dialog_theme, listener, y, m, d
        );
        datePicker.getDatePicker().maxDate = maxDate
        datePicker.show();
    }
}