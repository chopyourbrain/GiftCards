package com.example.giftcards

import com.example.giftcards.di.FeatureProxy
import com.example.giftcards.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()
        FeatureProxy.getGiftCardsFeature(this)
    }
}