package com.example.giftcards.data.repository

import com.example.core_network_api.data.HttpClientApi
import com.example.core_utils.domain.model.MainDTO
import com.example.giftcards.domain.repository.MainRemoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRemoteRepositoryImpl @Inject constructor(private val httpClient: HttpClientApi, private val mainLocalRepository: MainLocalRepositoryImpl):
    MainRemoteRepository {

    override fun getCardList(): MainDTO? {
        val mainDTO = httpClient.getCards() as MainDTO
        mainDTO.providers?.filterNotNull()?.let { mainLocalRepository.saveCompany(it) }
        return mainDTO
    }
}