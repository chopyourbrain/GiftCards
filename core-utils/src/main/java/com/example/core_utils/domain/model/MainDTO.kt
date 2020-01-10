package com.example.core_utils.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MainDTO : Serializable {
    @SerializedName("providers")
    var providers: List<com.example.core_utils.domain.model.CompanyDTO?>? = null
}