package com.example.giftcards.di.component

import android.content.Context
import com.example.core_db_api.di.CoreDBApi
import com.example.core_db_impl.di.CoreDBComponent
import com.example.core_db_impl.di.DatabaseModule
import com.example.core_network_api.di.CoreNetworkApi
import com.example.core_network_impl.di.CoreNetworkComponent
import com.example.giftcards.App
import com.example.giftcards.di.module.ActivityInjectorModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityInjectorModule::class
    ], dependencies = [CoreDBApi::class, CoreNetworkApi::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Context, coreDBApi: CoreDBApi, coreNetworkApi: CoreNetworkApi): AppComponent
    }
}