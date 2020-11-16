package com.example.core_db_impl.data

import com.example.core_db_api.data.DBApi
import com.example.core_utils.domain.model.CompanyDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DBApiImpl @Inject constructor(private val db: AppRoomDB) : DBApi {
    override suspend fun replaceCompany(companies: List<CompanyDTO>) {
        db.companyDao().replaceCompany(companies)
    }

    override suspend fun insertCompany(companies: List<CompanyDTO>) {
        db.companyDao().insertCompany(companies)
    }

    override suspend fun deleteCompany() {
        db.companyDao().deleteCompany()
    }

    override suspend fun getCompany(): Flow<List<CompanyDTO>> = db.companyDao().getCompany()

}