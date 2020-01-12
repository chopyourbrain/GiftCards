package com.example.giftcards.presentation.activity.main

import com.example.giftcards.presentation.fragments.detail.FragmentDetail
import com.example.giftcards.presentation.fragments.detail.FragmentDetailModule
import com.example.giftcards.presentation.fragments.main.FragmentMain
import com.example.giftcards.presentation.fragments.main.FragmentMainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentMainModule.ModuleScope
    @ContributesAndroidInjector(modules = [FragmentMainModule::class])
    abstract fun contributeFragmentMain(): FragmentMain

    @FragmentDetailModule.ModuleScope
    @ContributesAndroidInjector(modules = [FragmentDetailModule::class])
    abstract fun contributeFragmentDetail(): FragmentDetail
}