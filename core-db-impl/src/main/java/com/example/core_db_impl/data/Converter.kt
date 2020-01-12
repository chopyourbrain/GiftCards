package com.example.core_db_impl.data

import androidx.room.TypeConverter
import com.example.core_utils.domain.model.CardDTO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class Converter {
    @TypeConverter
    fun stringToCardList(data: String?): List<CardDTO> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<CardDTO>>() {

        }.type

        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun cardListToString(someObjects: List<CardDTO>): String {
        return Gson().toJson(someObjects)
    }
}