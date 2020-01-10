package com.example.feature_giftcards_impl.data.repository

import com.example.core_utils.domain.model.MainDTO
import com.example.feature_giftcards_impl.domain.repository.MainRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    private val mainRemoteRepository: MainRemoteRepository,
    private val mainLocalRepository: MainLocalRepository
) : MainRepository {

    override fun getCardList(): Single<MainDTO?> = mainRemoteRepository.getCardList().doOnSuccess {
        (it as MainDTO).providers?.let { list ->
            mainLocalRepository.saveCompany(list.filterNotNull())
        }
    }

    override fun getLocalCardList() = mainLocalRepository.getCompany()
}