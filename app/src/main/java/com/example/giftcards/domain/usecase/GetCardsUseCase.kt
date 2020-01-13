package com.example.giftcards.domain.usecase

import com.example.core_utils.domain.model.CompanyDTO
import com.example.giftcards.data.repository.MainLocalRepositoryImpl
import com.example.giftcards.data.repository.MainRemoteRepositoryImpl
import com.example.giftcards.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val localRepository: MainLocalRepositoryImpl, private val remoteRepository: MainRemoteRepositoryImpl) :
    SingleUseCase<List<CompanyDTO?>>() {

    override fun buildUseCaseSingle(): Single<List<CompanyDTO?>> {
        return remoteRepository.getCardList().map { it.providers.orEmpty() }
            .onErrorResumeNext { localRepository.getLocalCardList() }
    }
}