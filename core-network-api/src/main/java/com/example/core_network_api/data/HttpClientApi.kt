package com.example.core_network_api.data

import com.example.core_utils.domain.model.MainDTO
import kotlinx.coroutines.flow.Flow

interface HttpClientApi {
    suspend fun getCards(): Flow<MainDTO>
}