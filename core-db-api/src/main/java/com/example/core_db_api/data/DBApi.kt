package com.example.core_db_api.data

import com.example.core_utils.domain.model.CompanyDTO
import io.reactivex.Single

interface DBApi {
    fun insertCompany(companies: List<CompanyDTO>)
    fun deleteCompany()
    fun getCompany(): Single<List<CompanyDTO>>
}