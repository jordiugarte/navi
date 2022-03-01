package com.navitech.navi.ui.register.fragments.type

import androidx.lifecycle.ViewModelProvider
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

    private lateinit var viewModel: TypePickerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.type_picker_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TypePickerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}