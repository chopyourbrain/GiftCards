package com.example.feature_giftcards_impl.di

//import com.example.giftcards.presentation.activity.main.MainActivity
//import com.example.giftcards.presentation.activity.main.MainActivityModule
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(
    includes = [AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class]
)
abstract class ActivityInjectorModule {

//    @ActivityScope
//    @ContributesAndroidInjector(modules = [com.example.giftcards.presentation.activity.main.MainActivityModule::class])
//    internal abstract fun contributeSplashActivity(): com.example.giftcards.presentation.activity.main.MainActivity

}