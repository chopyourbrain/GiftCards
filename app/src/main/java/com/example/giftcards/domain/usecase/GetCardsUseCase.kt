package com.example.giftcards.domain.usecase

import com.example.core_utils.domain.model.CompanyDTO
import com.example.giftcards.domain.repository.MainLocalRepository
import com.example.giftcards.domain.repository.MainRemoteRepository
import com.example.giftcards.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEmpty
import javax.inject.Inject

class GetCardsUseCase @Inject constructor(
    private val localRepository: MainLocalRepository,
    private val remoteRepository: MainRemoteRepository
) : UseCase<Flow<List<CompanyDTO>>>() {

    override suspend fun buildUseCaseSingle(): Flow<List<CompanyDTO>> {
        return remoteRepository.getCardList().onEmpty { localRepository.getLocalCardList() }
            .mapNotNull { it.providers?.filterNotNull() }

    }
}