package com.navitech.navi.ui.register.fragments.type

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.navitech.navi.R

class TypePickerFragment : Fragment() {

    companion object {
        fun newInstance() = TypePickerFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.type_picker_fragment, container, false)
    }
}