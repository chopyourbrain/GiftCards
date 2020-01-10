package com.example.feature_giftcards_impl.di

import com.example.core_db_api.data.DBApi
import com.example.core_network_api.data.HttpClientApi

interface GiftCardsFeatureDependencies {
    val dbApi: DBApi
    val httpClientApi: HttpClientApi
}