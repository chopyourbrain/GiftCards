package com.example.core_network_impl.service

import com.example.core_utils.domain.model.MainDTO
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface MainService {

    @GET("db")
    suspend fun getCards(): Flow<MainDTO?>
}