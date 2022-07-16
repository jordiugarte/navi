package com.navitech.navi.ui.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.navitech.navi.R
import com.navitech.navi.data.model.AppActivityController
import com.navitech.navi.data.model.users.Account
import com.navitech.navi.data.repositories.register.RemoteUserSaver
import com.navitech.navi.ui.register.fragments.guide.GuideFragment
import com.navitech.navi.ui.register.fragments.tourist.TouristFragment
import com.navitech.navi.ui.register.fragments.type.TypePickerFragment
import com.navitech.navi.utils.DateFormat
import com.navitech.navi.utils.LayoutUtils
import com.navitech.navi.utils.ProgressBarManager
import com.parse.SaveCallback


class RegisterActivity : AppActivityController() {

    private val context = this
    private val TAG = "Register"
    private lateinit var auth: FirebaseAuth

    private var onType = true
    private var onTourist = false;

    private var typePickerFragment: TypePickerFragment = TypePickerFragment()
    private var touristFragment: TouristFragment = TouristFragment()
    private var guideFragment: GuideFragment = GuideFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initializeData()
        initializeViews()
    }

    private fun initializeData() {

    }

    private fun initializeViews() {
        LayoutUtils.setToolbar(context)
        replaceFragment(typePickerFragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        backHandler()
        return true
    }

    override fun onBackPressed() {
        backHandler()
    }

    private fun backHandler() {
        if (onType) {
            super.onBackPressed()
        } else {
            onType = true
            replaceFragment(typePickerFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            if (onType) R.anim.anim_enter_from_left else R.anim.anim_enter_from_right,
            if (onType) R.anim.anim_exit_to_right else R.anim.anim_exit_to_left,
            if (onType) R.anim.anim_enter_from_right else R.anim.anim_enter_from_left,
            if (onType) R.anim.anim_exit_to_left else R.anim.anim_exit_to_right
        )
        transaction.replace(R.id.viewPager, fragment)
        transaction.commit()
    }

    fun goToTouristRegister(view: View) {
        onType = false
        onTourist = true
        replaceFragment(touristFragment)
    }

    fun goToGuideRegister(view: View) {
        onType = false
        onTourist = false
        replaceFragment(guideFragment)
    }

    fun register(view: View) {
        if (validated()) {
            createAccount()
        }
    }

    private fun validated(): Boolean {
        return if (onTourist) {
            touristFragment.validated()
        } else {
            touristFragment.validated()
        }
    }

    private fun createAccount() {
        ProgressBarManager.show(context)
        RemoteUserSaver().save(generateUser()) {
            ProgressBarManager.hide()
            if (it == null) {

            } else {

            }
        }
    }

    private fun generateUser(): Account {
        if (onTourist) {
            return Account(
                touristFragment.username.text.toString(),
                touristFragment.names.text.toString(),
                touristFragment.lastNames.text.toString(),
                DateFormat.stringToDate(touristFragment.date.text.toString()),
                touristFragment.address.text.toString(),
                touristFragment.email.text.toString(),
                touristFragment.phone.text.toString(),
                touristFragment.country.text.toString(),
                touristFragment.city.text.toString(),
                touristFragment.ci.text.toString()
            )
        } else {
            return Account(
                guideFragment.username.text.toString(),
                guideFragment.names.text.toString(),
                guideFragment.lastNames.text.toString(),
                DateFormat.stringToDate(guideFragment.date.text.toString()),
                touristFragment.address.text.toString(),
                guideFragment.email.text.toString(),
                guideFragment.phone.text.toString(),
                guideFragment.country.text.toString(),
                guideFragment.city.text.toString(),
                guideFragment.ci.text.toString(),
                guideFragment.agencyName.text.toString(),
                DateFormat.stringToDate(guideFragment.agencyFoundationDate.text.toString())
            )
        }
    }
}