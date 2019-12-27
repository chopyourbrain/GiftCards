package com.example.giftcards.di.module

import com.example.giftcards.di.scope.AppActivityScope
import com.example.giftcards.presentation.activity.main.MainActivity
import com.example.giftcards.presentation.activity.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorModule {

    @AppActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun contributeSplashActivity(): MainActivity

}