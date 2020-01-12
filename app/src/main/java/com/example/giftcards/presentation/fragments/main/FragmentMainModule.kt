package com.example.giftcards.presentation.fragments.main

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
abstract class FragmentMainModule {

    @Module
    companion object {

        @ModuleScope
        @JvmStatic
        fun provideFragment(fragment: FragmentMain): Fragment = fragment

        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModel(impl: FragmentMainViewModelImpl): FragmentMainViewModel = impl

    }

    @Scope
    @kotlin.annotation.MustBeDocumented
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class ModuleScope

}