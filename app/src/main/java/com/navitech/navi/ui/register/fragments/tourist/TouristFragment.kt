package com.navitech.navi.ui.register.fragments.tourist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.navitech.navi.R

class TouristFragment : Fragment() {

    companion object {
        fun newInstance() = TouristFragment()
    }

    private lateinit var viewModel: TouristViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tourist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TouristViewModel::class.java)
        // TODO: Use the ViewModel
    }

}