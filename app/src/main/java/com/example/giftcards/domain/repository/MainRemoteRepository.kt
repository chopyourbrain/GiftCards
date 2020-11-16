package com.example.giftcards.domain.repository

import com.example.core_utils.domain.model.MainDTO
import kotlinx.coroutines.flow.Flow

interface MainRemoteRepository {
    suspend fun getCardList(): Flow<MainDTO>
}