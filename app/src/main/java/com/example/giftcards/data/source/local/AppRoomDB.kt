package com.example.giftcards.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.giftcards.domain.model.CompanyDTO

@Database(entities = [CompanyDTO::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppRoomDB: RoomDatabase() {
    abstract fun companyDao(): CompanyDao
}