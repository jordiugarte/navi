package com.navitech.navi.ui.register.fragments.guide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import com.google.android.material.textfield.TextInputLayout
import com.navitech.navi.R

class GuideFragment : Fragment() {

    lateinit var agencySwitch: Switch
    lateinit var agencyName: EditText
    lateinit var agencyFoundationDate: EditText
    lateinit var agreement: CheckBox
    lateinit var registerButton: Button

    companion object {
        fun newInstance() = GuideFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.guide_fragment, container, false)
        initializeViews(view)
        return view
    }

    private fun initializeViews(view: View) {
        agencySwitch = view.findViewById(R.id.guide_register_switch)
        agencyName = view.findViewById(R.id.guide_register_agency_name)
        agencyFoundationDate = view.findViewById(R.id.guide_register_agency_foundation_date)
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
    }

    fun validated(): Boolean {

        return true
    }
}