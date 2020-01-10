package com.example.feature_giftcards_impl.di

import com.example.feature_giftcards_api.GiftCardsStarter
import com.example.feature_giftcards_impl.start.GiftCardsStarterImpl
import dagger.Binds
import dagger.Module

@Module
interface GiftCardsFeatureModule {

    @Binds
    fun provideGiftCardsStarter(giftCardsStarter: GiftCardsStarterImpl): GiftCardsStarter
}