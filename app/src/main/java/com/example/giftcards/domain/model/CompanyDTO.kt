package com.example.giftcards.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CompanyDTO : Serializable {
    @SerializedName("id")
    var id: Long? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("image_url")
    var image_url: String? = null
    @SerializedName("gift_cards")
    var gift_cards: List<CardDTO?>? = null
}