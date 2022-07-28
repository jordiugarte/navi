package com.navitech.navi.ui.main.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.navitech.navi.R
import com.navitech.navi.data.model.travel.Category
import com.navitech.navi.data.model.weather.WeatherResult
import com.navitech.navi.data.repositories.category.RemoteCategoryLoader
import com.navitech.navi.data.services.weather.WeatherRepository
import com.navitech.navi.ui.main.fragments.home.adapter.CategoriesAdapter
import com.navitech.navi.utils.LayoutUtils
import com.navitech.navi.utils.PlaceUI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        recommendationsRecyclerView = LayoutUtils.setRecyclerView(
            this.requireActivity(),
            container,
            R.id.recycler_view_recommendations,
            LinearLayout.HORIZONTAL
        )
    }

    private fun getData() {
        RemoteCategoryLoader().loadAll() { objects, e ->
            if (e == null) {
                recommendationsList = objects
                setData()
            } else {

            }
        }
        WeatherRepository().get(-16.496899, -68.098001).enqueue(
            object : Callback<WeatherResult> {
                override fun onResponse(
                    call: Call<WeatherResult>,
                    response: Response<WeatherResult>
                ) {
                    PlaceUI.initialize(requireActivity(), response.body()!!)
                }

                override fun onFailure(call: Call<WeatherResult>, t: Throwable) {
                    Log.e("error", t.message!!)
                }

            }
        )
    }

    private fun setData() {
        recommendationsRecyclerView.adapter =
            CategoriesAdapter(this.requireContext(), recommendationsList)
    }

    //TODO GPS params
}