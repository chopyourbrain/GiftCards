package com.example.core_db_impl.di

import android.content.Context
import com.example.core_db_api.di.CoreDBApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DatabaseModule::class])
@Singleton
interface CoreDBComponent : CoreDBApi {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreDBApi
    }

}