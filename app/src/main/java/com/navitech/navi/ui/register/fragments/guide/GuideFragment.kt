package com.navitech.navi.ui.register.fragments.guide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.navitech.navi.R
import com.navitech.navi.data.model.users.Account
import com.navitech.navi.utils.Constants
import com.navitech.navi.utils.DateFormat
import com.navitech.navi.utils.DialogUtils
import com.navitech.navi.utils.Router
import java.util.*

class GuideFragment : Fragment() {

    lateinit var agencySwitch: Switch
    lateinit var name: EditText
    lateinit var agencyName: EditText
    lateinit var lastName: EditText
    lateinit var date: EditText
    lateinit var agencyFoundationDate: EditText
    lateinit var country: EditText
    lateinit var address: EditText
    lateinit var city: EditText
    lateinit var phone: EditText
    lateinit var ci: EditText
    lateinit var email: EditText
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var password2: EditText

    lateinit var agreement: CheckBox
    lateinit var registerButton: Button

    var bornDateTimeStamp: Long = System.currentTimeMillis()
    var bornDate: Date = Date(bornDateTimeStamp)
    var foundationDateTimeStamp: Long = System.currentTimeMillis()
    var foundationDate: Date = Date(foundationDateTimeStamp)

    private val responseCountry =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == AppCompatActivity.RESULT_OK) {
                country.setText(it.data?.getStringExtra(Constants.KEY_RESULT_VALUE))
            }
        }

    companion object {
        fun newInstance() = GuideFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_guide, container, false)
        initializeViews(view)
        return view
    }

    private fun initializeViews(view: View) {
        name = view.findViewById(R.id.guide_register_names)
        lastName = view.findViewById(R.id.guide_register_last_names)
        date = view.findViewById(R.id.guide_register_born_date)
        agencyName = view.findViewById(R.id.guide_register_agency_name)
        agencyFoundationDate = view.findViewById(R.id.guide_register_agency_foundation_date)
        country = view.findViewById(R.id.guide_register_country)
        ci = view.findViewById(R.id.guide_register_ci)
        phone = view.findViewById(R.id.guide_register_phone)
        email = view.findViewById(R.id.guide_register_email)
        username = view.findViewById(R.id.guide_register_username)
        password = view.findViewById(R.id.guide_register_password1)
        password2 = view.findViewById(R.id.guide_register_password2)

        agencySwitch = view.findViewById(R.id.guide_register_switch)
        agreement = view.findViewById(R.id.checkbox_agreement)
        registerButton = view.findViewById(R.id.register_button)
        agencySwitch.setOnCheckedChangeListener { _, b ->
            (agencyName.parent.parent as TextInputLayout).visibility = if (b) VISIBLE else GONE
            (agencyFoundationDate.parent.parent as TextInputLayout).visibility =
                if (b) VISIBLE else GONE
        }
        agreement.setOnCheckedChangeListener { _, b ->
            registerButton.isEnabled = b
        }
        agencyFoundationDate.setOnClickListener { setBornDate(agencyFoundationDate) }
        date.setOnClickListener { setBornDate(date) }
        country.setOnClickListener {
            Router.toCountries(requireActivity(), responseCountry)
        }
    }

    fun validated(): Boolean {

        return true
    }

    private fun setBornDate(view: EditText) {
        DialogUtils().pickBornDatePicker(
            requireActivity()
        ) { view1, year, month, dayOfMonth ->
            bornDate = DateFormat.dateFromParams(year, month, dayOfMonth)
            bornDateTimeStamp = bornDate.getTime()
            val stringDate = DateFormat.dateToString(
                bornDateTimeStamp,
                DateFormat.FORMAT_TYPE.ONLY_PRETTY_DATE
            )
            view.setText(stringDate)
        }
    }

    fun guideAccount(): Account {
        return Account(
            username.text.toString(),
            name.text.toString(),
            lastName.text.toString(),
            DateFormat.stringToDate(date.text.toString(), DateFormat.FORMAT_TYPE.ONLY_PRETTY_DATE),
            address.text.toString(),
            email.text.toString(),
            phone.text.toString(),
            country.text.toString(),
            city.text.toString(),
            ci.text.toString(),
            agencyName.text.toString(),
            DateFormat.stringToDate(agencyFoundationDate.text.toString(), DateFormat.FORMAT_TYPE.ONLY_PRETTY_DATE)
        )
    }
}