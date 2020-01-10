package com.example.feature_giftcards_impl.presentation.fragments.detail

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
abstract class FragmentDetailModule {

    @Module
    companion object {

        @ModuleScope
        @JvmStatic
        fun provideFragment(fragment: FragmentDetail): Fragment = fragment

        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModel(impl: FragmentDetailViewModelImpl): FragmentDetailViewModel = impl

    }

    @Scope
    @kotlin.annotation.MustBeDocumented
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class ModuleScope

}