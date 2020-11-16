package com.example.core_network_impl.data

import com.example.core_network_api.data.HttpClientApi
import com.example.core_network_impl.mock.MockResponse
import com.example.core_network_impl.service.MainService
import com.example.core_utils.domain.model.MainDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import java.lang.Exception
import javax.inject.Inject

class HttpClientImpl @Inject constructor(retrofit: Retrofit) : HttpClientApi {

    private val service = retrofit.create(MainService::class.java)

    override suspend fun getCards(): Flow<MainDTO> =
        try {
            service.getCards().filterNotNull()
        } catch (e: Exception) {
            flow { emit(MockResponse.getCardResponse()) }
        }

}