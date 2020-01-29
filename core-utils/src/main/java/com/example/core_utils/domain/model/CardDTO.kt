package com.example.core_utils.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CardDTO : Serializable {
    @SerializedName("id")
    var id: Long? = null
    @SerializedName("featured")
    var featured: Boolean? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("credits")
    var credits: Long? = null
    @SerializedName("image_url")
    var imageUrl: String? = null
    @SerializedName("codes_count")
    var codesCount: Int? = null
    @SerializedName("currency")
    var currency: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("redeem_url")
    var redeemUrl: String? = null
}