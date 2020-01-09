package com.example.giftcards.data.source.local

import androidx.room.TypeConverter
import com.example.giftcards.domain.model.CardDTO
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