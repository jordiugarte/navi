package com.navitech.navi.ui.register

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.navitech.navi.R
import com.navitech.navi.data.model.AppActivityController
import com.navitech.navi.ui.register.fragments.guide.GuideFragment
import com.navitech.navi.ui.register.fragments.tourist.TouristFragment
import com.navitech.navi.ui.register.fragments.type.TypePickerFragment
import com.navitech.navi.utils.LayoutUtils


class RegisterActivity : AppActivityController() {

    private val context = this
    private val TAG = "Register"
    private lateinit var auth: FirebaseAuth

    private var onType = true

    private var typePickerFragment: TypePickerFragment = TypePickerFragment()
    var touristFragment: TouristFragment = TouristFragment()
    var guideFragment: GuideFragment = GuideFragment()

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

    fun backHandler() {
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
        replaceFragment(touristFragment)
    }

    fun goToGuideRegister(view: View) {
        onType = false
        replaceFragment(guideFragment)
    }

    fun register(view: View) {

    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }
            }
    }
}