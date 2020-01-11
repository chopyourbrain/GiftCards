package com.example.feature_giftcards_impl.di

import com.example.feature_giftcards_impl.presentation.activity.main.MainActivity
import com.example.feature_giftcards_impl.presentation.activity.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun contributeSplashActivity(): MainActivity

}