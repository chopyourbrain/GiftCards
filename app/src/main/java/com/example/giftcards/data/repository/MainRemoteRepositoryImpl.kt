package com.example.giftcards.data.repository

import com.example.core_network_api.data.HttpClientApi
import com.example.core_utils.domain.model.MainDTO
import com.example.giftcards.domain.repository.MainRemoteRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRemoteRepositoryImpl @Inject constructor(private val httpClient: HttpClientApi, private val mainLocalRepository: MainLocalRepositoryImpl):
    MainRemoteRepository {

    override fun getCardList(): Single<MainDTO?> = httpClient.getCards().doOnSuccess {
        (it as MainDTO).providers?.let { list ->
            mainLocalRepository.saveCompany(list.filterNotNull())
        }
    }
}