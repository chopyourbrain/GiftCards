package com.example.giftcards

import com.example.core_db_impl.di.DaggerCoreDBComponent
import com.example.core_network_impl.di.DaggerCoreNetworkComponent
import com.example.giftcards.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(
            this,
            DaggerCoreDBComponent.factory().create(this),
            DaggerCoreNetworkComponent.factory().create()
        )

    override fun onCreate() {
        super.onCreate()
//        FeatureProxy.getGiftCardsFeature(this)
    }
}