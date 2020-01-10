package com.example.feature_giftcards_impl.domain.usecase

import com.example.feature_giftcards_impl.data.repository.MainRepositoryImpl
import com.example.feature_giftcards_impl.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val repository: MainRepositoryImpl) :
    SingleUseCase<List<com.example.core_utils.domain.model.CompanyDTO?>>() {

    override fun buildUseCaseSingle(): Single<List<com.example.core_utils.domain.model.CompanyDTO?>> {
        return repository.getCardList().map { it.providers.orEmpty() }
            .onErrorResumeNext { repository.getLocalCardList() }
    }
}