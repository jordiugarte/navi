package com.navitech.navi.ui.main.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.navitech.navi.R
import com.navitech.navi.ui.main.fragments.home.adapter.RecommendationsAdapter
import com.navitech.navi.utils.LayoutUtils

class HomeFragment : Fragment() {

    private var recommendationsList: MutableList<String> = arrayListOf()

    lateinit var recommendationsRecyclerView: RecyclerView

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val parent: View = inflater.inflate(R.layout.home_fragment, container, false)
        initViews(parent)
        getData()
        return parent
    }

    private fun initViews(container: View) {
        recommendationsRecyclerView = LayoutUtils.setRecyclerView(this.requireActivity(), container, R.id.recycler_view_recommendations, LinearLayout.HORIZONTAL)
    }

    private fun getData(){
        recommendationsList.add("Tours")
        recommendationsList.add("Caminatas")
        setData()
    }

    private fun setData() {
        recommendationsRecyclerView.adapter = RecommendationsAdapter(this.requireContext(), recommendationsList)
    }
}