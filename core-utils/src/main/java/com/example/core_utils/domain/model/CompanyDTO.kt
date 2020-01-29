package com.example.core_utils.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "company_table")
class CompanyDTO : Serializable {
    @PrimaryKey
    @SerializedName("id")
    var id: Long? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("image_url")
    var imageUrl: String? = null
    @SerializedName("gift_cards")
    var giftCards: List<CardDTO?>? = null
}