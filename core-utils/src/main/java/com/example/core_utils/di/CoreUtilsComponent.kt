package com.example.core_utils.di

import dagger.Component
import javax.inject.Singleton

@Component(modules = [])
@Singleton
interface CoreUtilsComponent : CoreUtilsApi {

    @Component.Factory
    interface Factory {
        fun create(): CoreUtilsApi
    }

}