package com.navitech.navi.ui.register.fragments.tourist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import com.navitech.navi.R

class TouristFragment : Fragment() {

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
        agreement = view.findViewById(R.id.checkbox_agreement)
        registerButton = view.findViewById(R.id.register_button)
        agreement.setOnCheckedChangeListener { _, b ->
            registerButton.isEnabled = b
        }
    }
}