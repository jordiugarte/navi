package com.navitech.navi.ui.attraction

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.navitech.navi.R
import com.navitech.navi.data.local.ParametersData
import com.navitech.navi.data.model.travel.attraction.Attraction
import com.navitech.navi.ui.NaviActivity
import com.navitech.navi.utils.Constants.KEY_ATTRACTION
import com.navitech.navi.utils.LayoutUtils
import com.navitech.navi.utils.Router
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener


class AttractionActivity : NaviActivity() {

    lateinit var attraction: Attraction

    lateinit var carousel: CarouselView
    lateinit var title: TextView
    lateinit var description: TextView
    lateinit var price: TextView
    lateinit var place: TextView
    lateinit var rating: Chip
    lateinit var categories: ChipGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attraction)
        getData()
        initViews()
        setViews()
    }

    private fun getData() {
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            attraction = bundle.getSerializable(KEY_ATTRACTION) as Attraction
        }
    }

    private fun initViews() {
        carousel = findViewById(R.id.carouselView)
        title = findViewById(R.id.attraction_title)
        description = findViewById(R.id.attraction_description)
        price = findViewById(R.id.attraction_price)
        place = findViewById(R.id.attraction_place)
        rating = findViewById(R.id.attraction_rating)
        categories = findViewById(R.id.attraction_category)
    }

    private fun setViews() {
        title.text = attraction.name
        description.text = attraction.description
        price.text = "${attraction.price} ${
            ParametersData().getCurrencyByCountry(
                this,
                attraction.country
            )
        } / ${getString(R.string.noun_person)}"
        place.text = "${attraction.city}, ${attraction.country}"
        rating.text = "${attraction.rating}"
        LayoutUtils.setChipCategories(this, attraction.categories, categories)

        carousel.setPageCount(attraction.photos.size)
        carousel.setImageListener(imageListener)
    }

    var imageListener =
        ImageListener { position, imageView ->
            LayoutUtils.setImage(
                this,
                attraction.photos[position],
                imageView
            )
            imageView.setOnClickListener {
                imageView.invalidate()
                val drawable = imageView.drawable as BitmapDrawable
                val bitmap = drawable.bitmap
                Router.toImageView(this, bitmap)
            }
        }
}