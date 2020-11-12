package com.example.giftcards.domain.repository

import com.example.core_utils.domain.model.MainDTO

interface MainRemoteRepository {
    fun getCardList(): MainDTO?
}