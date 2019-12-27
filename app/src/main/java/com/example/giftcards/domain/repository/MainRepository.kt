package com.example.giftcards.domain.repository

import com.example.giftcards.domain.model.MainDTO
import io.reactivex.Single

interface MainRepository {
    fun getCardList(): Single<MainDTO?>
}