package com.navitech.navi.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.navitech.navi.R
import com.navitech.navi.data.model.users.NewAccount
import com.navitech.navi.data.repositories.register.RemoteUserSaver
import com.navitech.navi.ui.NaviActivity
import com.navitech.navi.ui.register.fragments.guide.GuideFragment
import com.navitech.navi.ui.register.fragments.tourist.TouristFragment
import com.navitech.navi.ui.register.fragments.type.TypePickerFragment
import com.navitech.navi.utils.Constants.KEY_RESULT_VALUE
import com.navitech.navi.utils.Constants.REQUEST_CODE_COUNTRY
import com.navitech.navi.utils.DialogUtils
import com.navitech.navi.utils.LayoutUtils
import com.navitech.navi.utils.ProgressBarManager


class RegisterActivity : NaviActivity() {

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
            guideFragment.validated()
        }
    }

    private fun createAccount() {
        ProgressBarManager.show(context)
        RemoteUserSaver().save(generateUser()) {
            ProgressBarManager.hide()
            if (it == null) {
                Toast.makeText(context, "New account created successfully", Toast.LENGTH_LONG)
                    .show()
            } else {
                DialogUtils().showDialog(
                    context,
                    getString(R.string.noun_error),
                    getString(R.string.error_message_register)
                )
            }
        }
    }

    private fun generateUser(): NewAccount {
        if (onTourist) {
            return NewAccount(
                touristFragment.username.toString(),
                touristFragment.email.toString(),
                touristFragment.password.toString(),
                touristFragment.touristAccount()
            )
        } else {
            return NewAccount(
                guideFragment.username.toString(),
                guideFragment.email.toString(),
                guideFragment.password.toString(),
                guideFragment.guideAccount()
            )
        }
    }
}