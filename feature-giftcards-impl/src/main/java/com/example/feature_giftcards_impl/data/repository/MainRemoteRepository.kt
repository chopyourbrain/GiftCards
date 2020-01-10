package com.example.feature_giftcards_impl.data.repository

import com.example.core_network_api.data.HttpClientApi
import com.example.core_utils.domain.model.MainDTO
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRemoteRepository @Inject constructor(private val httpClient: HttpClientApi) {

    fun getCardList(): Single<MainDTO?> = httpClient.getCards()
}