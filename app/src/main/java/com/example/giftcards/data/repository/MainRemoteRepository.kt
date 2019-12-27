package com.example.giftcards.data.repository

import com.example.giftcards.data.source.remote.retrofit.MainService
import com.example.giftcards.data.source.remote.retrofit.TransportProvider
import com.example.giftcards.domain.model.MainDTO
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRemoteRepository @Inject constructor() {
    private val service = TransportProvider.createInstance().create(MainService::class.java)

    fun getCardList(): Single<MainDTO?> = service.getCards()
}