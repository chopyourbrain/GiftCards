package com.example.feature_giftcards_impl.domain.repository

import io.reactivex.Single

interface MainRepository {
    fun getCardList(): Single<com.example.core_utils.domain.model.MainDTO?>
    fun getLocalCardList(): Single<List<com.example.core_utils.domain.model.CompanyDTO>>
}