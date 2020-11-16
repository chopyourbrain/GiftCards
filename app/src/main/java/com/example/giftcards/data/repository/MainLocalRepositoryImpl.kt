package com.example.giftcards.data.repository

import com.example.core_db_api.data.DBApi
import com.example.core_utils.domain.model.CompanyDTO
import com.example.giftcards.domain.repository.MainLocalRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainLocalRepositoryImpl @Inject constructor(private val dbApi: DBApi) : MainLocalRepository {

    suspend fun saveCompany(list: List<CompanyDTO>) {
        dbApi.replaceCompany(list)
    }

    override suspend fun getLocalCardList() = dbApi.getCompany()

}