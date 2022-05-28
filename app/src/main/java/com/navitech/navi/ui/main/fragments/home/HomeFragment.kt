package com.navitech.navi.ui.main.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.navitech.navi.R
import com.navitech.navi.data.model.attractions.Category
import com.navitech.navi.ui.main.fragments.home.adapter.CategoriesAdapter
import com.navitech.navi.utils.CurrentPlaceLayout
import com.navitech.navi.utils.LayoutUtils

class HomeFragment : Fragment() {

    private var recommendationsList: MutableList<Category> = arrayListOf()

    lateinit var fragmentView: View
    lateinit var recommendationsRecyclerView: RecyclerView

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.home_fragment, container, false)
        initViews(fragmentView)
        getData()
        return fragmentView
    }

    private fun initViews(container: View) {
        recommendationsRecyclerView = LayoutUtils.setRecyclerView(this.requireActivity(), container, R.id.recycler_view_recommendations, LinearLayout.HORIZONTAL)
    }

    private fun getData(){
        for (i in 0 .. 9) {
            recommendationsList.add(
                Category(
                    i
                )
            )
        }
        setData()
    }

    private fun setData() {
        recommendationsRecyclerView.adapter = CategoriesAdapter(this.requireContext(), recommendationsList)
        CurrentPlaceLayout(this.requireActivity(), fragmentView).setData()
    }
}