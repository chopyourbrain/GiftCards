package com.example.giftcards.domain.repository

import com.example.giftcards.domain.model.CompanyDTO
import com.example.giftcards.domain.model.MainDTO
import io.reactivex.Single

interface MainRepository {
    fun getCardList(): Single<MainDTO?>
    fun getLocalCardList(): Single<List<CompanyDTO>>
}