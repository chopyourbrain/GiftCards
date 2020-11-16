package com.example.giftcards.domain.repository

import com.example.core_utils.domain.model.CompanyDTO
import kotlinx.coroutines.flow.Flow

interface MainLocalRepository {
    suspend fun getLocalCardList(): Flow<List<CompanyDTO>>
}