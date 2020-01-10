package com.example.core_db_impl.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class Converter {
    @TypeConverter
    fun stringToCardList(data: String?): List<com.example.core_utils.domain.model.CardDTO> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<com.example.core_utils.domain.model.CardDTO>>() {

        }.type

        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun cardListToString(someObjects: List<com.example.core_utils.domain.model.CardDTO>): String {
        return Gson().toJson(someObjects)
    }
}