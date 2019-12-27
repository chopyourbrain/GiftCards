package com.example.giftcards.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CardDTO : Serializable {
    @SerializedName("id")
    val id: Long? = null
    @SerializedName("featured")
    val featured: Boolean? = null
    @SerializedName("title")
    val title: String? = null
    @SerializedName("credits")
    val credits: Long? = null
    @SerializedName("image_url")
    val image_url: String? = null
    @SerializedName("codes_count")
    val codes_count: Int? = null
    @SerializedName("currency")
    val currency: String? = null
    @SerializedName("description")
    val description: String? = null
    @SerializedName("redeem_url")
    val redeem_url: String? = null
}