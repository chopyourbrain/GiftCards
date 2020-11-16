package com.example.core_db_api.data

import com.example.core_utils.domain.model.CompanyDTO
import kotlinx.coroutines.flow.Flow

interface DBApi {
    suspend fun replaceCompany(companies: List<CompanyDTO>)
    suspend fun insertCompany(companies: List<CompanyDTO>)
    suspend fun deleteCompany()
    suspend fun getCompany(): Flow<List<CompanyDTO>>
}