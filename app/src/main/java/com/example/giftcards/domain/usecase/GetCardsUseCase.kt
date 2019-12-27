package com.example.giftcards.domain.usecase

import com.example.giftcards.data.repository.MainRepositoryImpl
import com.example.giftcards.domain.model.CompanyDTO
import com.example.giftcards.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(private val repository: MainRepositoryImpl) : SingleUseCase<List<CompanyDTO?>>() {

    override fun buildUseCaseSingle(): Single<List<CompanyDTO?>> {
        return repository.getCardList().map { it.providers.orEmpty() }

    }
}