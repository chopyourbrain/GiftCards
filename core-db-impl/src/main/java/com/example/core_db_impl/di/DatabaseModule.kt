package com.example.core_db_impl.di

import android.content.Context
import androidx.room.Room
import com.example.core_db_impl.data.AppRoomDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): AppRoomDB {
        return Room.databaseBuilder(
            context,
            AppRoomDB::class.java,
            "store_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}