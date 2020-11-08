package com.example.giftcards.domain.repository

import com.example.core_utils.domain.model.CompanyDTO

interface MainLocalRepository {
    fun getLocalCardList(): List<CompanyDTO>
}