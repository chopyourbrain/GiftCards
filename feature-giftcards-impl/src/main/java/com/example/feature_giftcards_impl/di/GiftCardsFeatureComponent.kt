package com.example.feature_giftcards_impl.di

import com.example.core_db_api.di.CoreDBApi
import com.example.core_network_api.di.CoreNetworkApi
import com.example.core_utils.di.CoreUtilsApi
import com.example.feature_giftcards_api.GiftCardsFeatureApi
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [GiftCardsFeatureModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
    ActivityInjectorModule::class], dependencies = [GiftCardsFeatureDependencies::class]
)
interface GiftCardsFeatureComponent : GiftCardsFeatureApi {


    @Component.Factory
    interface Factory {
        fun create(giftCardsFeatureDependencies: GiftCardsFeatureDependencies): GiftCardsFeatureApi
    }

//    abstract fun inject(mainActivity: MainActivity)

    @Component(dependencies = [CoreDBApi::class, CoreNetworkApi::class, CoreUtilsApi::class])
    interface GiftCardsFeatureDependenciesComponent : GiftCardsFeatureDependencies {
        @Component.Factory
        interface Factory {
            fun create(
                coreDBApi: CoreDBApi,
                coreNetworkApi: CoreNetworkApi,
                coreUtilsApi: CoreUtilsApi
            ): GiftCardsFeatureDependenciesComponent
        }
    }
}