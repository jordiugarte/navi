package com.navitech.navi.ui.register.fragments.tourist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.navitech.navi.R
import com.navitech.navi.utils.Validator

class TouristFragment : Fragment() {

    lateinit var names: EditText
    lateinit var lastNames: EditText
    lateinit var date: EditText
    lateinit var country: EditText
    lateinit var phone: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var password2: EditText

    lateinit var agreement: CheckBox
    lateinit var registerButton: Button

    companion object {
        fun newInstance() = TouristFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.tourist_fragment, container, false)
        initializeViews(view)
        return view
    }

    private fun initializeViews(view: View) {
        names = view.findViewById(R.id.tourist_register_name)
        lastNames = view.findViewById(R.id.tourist_register_last_name)
        date = view.findViewById(R.id.tourist_register_born_date)
        country = view.findViewById(R.id.tourist_register_country)
        phone = view.findViewById(R.id.tourist_register_phone)
        email = view.findViewById(R.id.tourist_register_email)
        password = view.findViewById(R.id.tourist_register_password)
        password2 = view.findViewById(R.id.tourist_register_password2)

        agreement = view.findViewById(R.id.checkbox_agreement)
        registerButton = view.findViewById(R.id.register_button)
        agreement.setOnCheckedChangeListener { _, b ->
            registerButton.isEnabled = b
        }
    }

    fun validated(): Boolean {
        if (!Validator.names(names.text.toString())) {
            names.error = getString(R.string.error_invalid_names)
            return false
        }
        if (!Validator.names(lastNames.text.toString())) {
            lastNames.error = getString(R.string.error_invalid_last_names)
            return false
        }
        if (!Validator.notEmpty(date.text.toString())) {
            date.error = getString(R.string.error_empty_date)
            return false
        }
        if (!Validator.notEmpty(country.text.toString())) {
            country.error = getString(R.string.error_empty_country)
            return false
        }
        if (!Validator.phone(phone.text.toString())) {
            phone.error = getString(R.string.error_invalid_phone)
            return false
        }
        if (!Validator.email(email.text.toString())) {
            email.error = getString(R.string.error_invalid_email)
            return false
        }
        if (!Validator.password(password.text.toString())) {
            password.error = getString(R.string.error_invalid_password)
            return false
        }
        if (password.text.toString().equals(password2.text.toString())) {
            password2.error = getString(R.string.error_invalid_second_password)
            return false
        }
        return true
    }
}