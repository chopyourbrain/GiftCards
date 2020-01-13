package com.example.giftcards.domain.repository

import com.example.core_utils.domain.model.CompanyDTO
import io.reactivex.Single

interface MainLocalRepository {
    fun getLocalCardList(): Single<List<CompanyDTO>>
}