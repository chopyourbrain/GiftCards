package com.example.giftcards.data.repository

import com.example.core_utils.domain.model.MainDTO
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    private val mainRemoteRepository: MainRemoteRepository,
    private val mainLocalRepository: MainLocalRepository
) : com.example.giftcards.domain.repository.MainRepository {

    override fun getCardList(): Single<MainDTO?> = mainRemoteRepository.getCardList().doOnSuccess {
        (it as MainDTO).providers?.let { list ->
            mainLocalRepository.saveCompany(list.filterNotNull())
        }
    }

    override fun getLocalCardList() = mainLocalRepository.getCompany()
}