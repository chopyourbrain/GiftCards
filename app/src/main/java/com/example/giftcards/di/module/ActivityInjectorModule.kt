package com.example.giftcards.di.module

import com.example.feature_giftcards_impl.presentation.activity.main.MainActivity
import com.example.feature_giftcards_impl.presentation.activity.main.MainActivityModule
import com.example.giftcards.di.scope.AppActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorModule {

    @AppActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun contributeSplashActivity(): MainActivity

}