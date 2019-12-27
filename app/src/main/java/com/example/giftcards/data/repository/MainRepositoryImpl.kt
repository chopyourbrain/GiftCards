package com.example.giftcards.data.repository

import com.example.giftcards.domain.model.MainDTO
import com.example.giftcards.domain.repository.MainRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(private val mainRemoteRepository: MainRemoteRepository): MainRepository {

    override fun getCardList(): Single<MainDTO?> = mainRemoteRepository.getCardList()
}