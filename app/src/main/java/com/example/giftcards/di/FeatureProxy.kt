package com.example.giftcards.di

import android.content.Context
import com.example.core_db_impl.di.DaggerCoreDBComponent
import com.example.core_network_impl.di.DaggerCoreNetworkComponent
import com.example.core_utils.di.DaggerCoreUtilsComponent
import com.example.feature_giftcards_api.GiftCardsFeatureApi
import com.example.feature_giftcards_impl.di.DaggerGiftCardsFeatureComponent
import com.example.feature_giftcards_impl.di.DaggerGiftCardsFeatureComponent_GiftCardsFeatureDependenciesComponent

class FeatureProxy {

    companion object {
        fun getGiftCardsFeature(context: Context): GiftCardsFeatureApi =
            DaggerGiftCardsFeatureComponent.factory().create(
                DaggerGiftCardsFeatureComponent_GiftCardsFeatureDependenciesComponent.factory().create(
                    DaggerCoreDBComponent.factory().create(context),
                    DaggerCoreNetworkComponent.factory().create(),
                    DaggerCoreUtilsComponent.factory().create()
                )
            )
    }

}