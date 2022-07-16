package com.navitech.navi.ui.main.fragments.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.navitech.navi.R
import com.navitech.navi.data.local.PersistedData
import com.navitech.navi.data.model.users.Account
import com.navitech.navi.utils.LayoutUtils

class ProfileFragment : Fragment() {

    lateinit var nameView: TextView
    lateinit var biographyView: TextView
    lateinit var pictureView: ImageView

    lateinit var account: Account

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile_fragment, container, false)
        initializeViews(view)
        return view
    }

    private fun initializeViews(view: View) {
        nameView = view.findViewById(R.id.profile_name)
        biographyView = view.findViewById(R.id.profile_biography)
        pictureView = view.findViewById(R.id.profile_picture)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        account = PersistedData.getCurrentAccount()
        nameView.text = account.name + " " + account.lastName
        biographyView.text = account.biography
        LayoutUtils.setImage(requireActivity(), account.picture, pictureView)
    }

}