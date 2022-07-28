package com.navitech.navi.ui

import android.app.Application
import android.graphics.Rect
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.color.DynamicColors
import com.google.android.material.elevation.SurfaceColors
import com.navitech.navi.utils.LayoutUtils


open class NaviActivity : AppCompatActivity() {

    lateinit var activityTitle: String

    val app: Application
        get() = this.application

    override fun onResume() {
        super.onResume()
        DynamicColors.applyToActivityIfAvailable(this)
        window.navigationBarColor = SurfaceColors.SURFACE_2.getColor(this)
    }

    override fun onStop() {
        super.onStop()
    }

    public override fun onPause() {
        super.onPause()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    Log.d("focus", "touchevent")
                    v.clearFocus()
                    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    fun setActivityTitle(title: Int) {
        activityTitle = getString(title)
        LayoutUtils.setToolbar(this, activityTitle)
    }
}