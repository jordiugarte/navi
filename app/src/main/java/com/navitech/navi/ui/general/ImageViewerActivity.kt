package com.navitech.navi.ui.general

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.navitech.navi.R
import com.navitech.navi.utils.Constants.KEY_IMAGE


class ImageViewerActivity : AppCompatActivity() {
    class FullScreenImage : Activity() {
        public override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_image_viewer)
            val extras = intent.extras
            val bmp = extras!!.getParcelable<Parcelable>(KEY_IMAGE) as Bitmap
            val imgDisplay: ImageView
            val btnClose: Button
            imgDisplay = findViewById<View>(R.id.imgDisplay) as ImageView
            btnClose = findViewById<View>(R.id.btnClose) as Button
            btnClose.setOnClickListener { finish() }
            imgDisplay.setImageBitmap(bmp)
        }
    }
}