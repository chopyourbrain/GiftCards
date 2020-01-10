package com.example.core_network_impl.di

import com.example.core_network_api.di.CoreNetworkApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface CoreNetworkComponent : CoreNetworkApi {

    @Component.Factory
    interface Factory {
        fun create(): CoreNetworkApi
    }

}