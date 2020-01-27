package com.example.giftcards.domain.usecase

import com.example.core_utils.domain.model.CompanyDTO
import com.example.giftcards.domain.repository.MainLocalRepository
import com.example.giftcards.domain.repository.MainRemoteRepository
import com.example.giftcards.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val localRepository: MainLocalRepository, private val remoteRepository: MainRemoteRepository) :
    SingleUseCase<List<CompanyDTO?>>() {

    override fun buildUseCaseSingle(): Single<List<CompanyDTO?>> {
        return remoteRepository.getCardList().map { it.providers.orEmpty() }
            .onErrorResumeNext { localRepository.getLocalCardList() }
    }
}