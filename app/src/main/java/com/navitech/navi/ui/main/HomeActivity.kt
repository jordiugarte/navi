package com.navitech.navi.ui.main

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.elevation.SurfaceColors
import com.navitech.navi.R
import com.navitech.navi.ui.NaviActivity
import com.navitech.navi.ui.main.fragments.home.HomeFragment
import com.navitech.navi.ui.main.fragments.profile.ProfileFragment
import com.navitech.navi.ui.main.fragments.travels.TravelsFragment
import com.navitech.navi.utils.Constants.LOCATION_REQUEST_CODE
import com.navitech.navi.utils.PermissionManager
import com.navitech.navi.utils.Router

class HomeActivity : NaviActivity(), LifecycleOwner {

    private val TAG = "Home"
    val context: Context = this

    private lateinit var bottomNavigation: BottomNavigationView

    private var homeFragment: HomeFragment = HomeFragment()
    private var travelsFragment: TravelsFragment = TravelsFragment()
    private var profileFragment: ProfileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        checkPermissions()
        initializeViews()
    }

    private fun checkPermissions() {
        if (!PermissionManager.checkLocationPermission(context)) {
            PermissionManager.requestLocationPermission(context)
        }
    }

    private fun initializeViews() {
        bottomNavigation = findViewById(R.id.bottom_navigation)
        replaceFragment(homeFragment)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> replaceFragment(homeFragment)
                R.id.menu_maps -> replaceFragment(travelsFragment)
                R.id.menu_profile -> replaceFragment(profileFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.viewPager, fragment)
        transaction.commit()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] !=
                    PackageManager.PERMISSION_GRANTED
                ) {
                    Toast.makeText(context, "Permiso denegado", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    fun toPlace(view: View) {
        Router.toPlace(context)
    }
}