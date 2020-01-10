package com.example.core_db_impl.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.core_utils.domain.model.CompanyDTO

@Database(entities = [CompanyDTO::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppRoomDB: RoomDatabase() {
    abstract fun companyDao(): CompanyDao
}