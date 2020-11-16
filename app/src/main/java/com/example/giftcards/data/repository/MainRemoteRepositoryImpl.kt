package com.example.giftcards.data.repository

import com.example.core_network_api.data.HttpClientApi
import com.example.core_utils.domain.model.MainDTO
import com.example.giftcards.domain.repository.MainRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRemoteRepositoryImpl @Inject constructor(private val httpClient: HttpClientApi, private val mainLocalRepository: MainLocalRepositoryImpl):
    MainRemoteRepository {

    override suspend fun getCardList(): Flow<MainDTO> {
        val mainDTO = httpClient.getCards()
        mainDTO.map { it.providers?.filterNotNull()?.let { mainLocalRepository.saveCompany(it) }}
        return mainDTO
    }
}