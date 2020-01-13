package com.example.giftcards.domain.repository

import com.example.core_utils.domain.model.MainDTO
import io.reactivex.Single

interface MainRemoteRepository {
    fun getCardList(): Single<MainDTO?>
}