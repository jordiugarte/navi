package com.navitech.navi.ui.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.navitech.navi.R
import com.navitech.navi.ui.main.fragments.home.HomeFragment
import com.navitech.navi.ui.main.fragments.profile.ProfileFragment
import com.navitech.navi.ui.main.fragments.travels.TravelsFragment

class MainActivity : AppCompatActivity(), LifecycleOwner {

    val TAG: String = "MAIN"
    val context: Context = this
    private lateinit var viewModel: ViewModel

    private lateinit var bottomNavigation: BottomNavigationView
    private var homeFragment: HomeFragment = HomeFragment()
    private var travelsFragment: TravelsFragment = TravelsFragment()
    private var profileFragment: ProfileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeData()
        initializeViews()
    }

    private fun initializeData() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
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
}