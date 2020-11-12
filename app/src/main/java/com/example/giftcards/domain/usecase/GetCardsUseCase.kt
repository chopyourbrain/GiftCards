package com.example.giftcards.domain.usecase

import com.example.core_utils.domain.model.CompanyDTO
import com.example.giftcards.domain.repository.MainLocalRepository
import com.example.giftcards.domain.repository.MainRemoteRepository
import com.example.giftcards.domain.usecase.base.UseCase
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val localRepository: MainLocalRepository, private val remoteRepository: MainRemoteRepository) :
    UseCase<List<CompanyDTO?>>() {

    override fun buildUseCaseSingle(): List<CompanyDTO?> {
        return remoteRepository.getCardList()?.providers ?: localRepository.getLocalCardList()
    }
}