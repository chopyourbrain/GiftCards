package com.example.core_db_impl.di

import android.content.Context
import androidx.room.Room
import com.example.core_db_api.data.DBApi
import com.example.core_db_impl.data.AppRoomDB
import com.example.core_db_impl.data.DBApiImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DatabaseModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
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

    @Binds
    abstract fun provideDBApi(dbApiImpl: DBApiImpl): DBApi
}