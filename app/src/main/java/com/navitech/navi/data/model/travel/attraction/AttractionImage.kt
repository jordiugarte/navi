package com.navitech.navi.data.model.travel.attraction

import com.navitech.navi.data.model.GenericModel
import com.navitech.navi.data.model.travel.attraction.Attraction
import com.parse.ParseClassName
import com.parse.ParseFile
import java.io.Serializable

@ParseClassName("attraction_image")
class AttractionImage() : GenericModel(), Serializable {
    var image: ParseFile
        get() = getParseFile("image")
        set(coverPhoto) {
            put("image", coverPhoto)
        }
    var attractionId: String
        get() = getString("attraction_id")
        set(body) {
            put("attraction_id", body)
        }
    var attraction: Attraction
        get() = getParseObject("attraction") as Attraction
        set(body) {
            put("attraction", body)
        }
}
