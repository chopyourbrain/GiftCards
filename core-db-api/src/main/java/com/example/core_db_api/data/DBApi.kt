package com.example.core_db_api.data

import com.example.core_utils.domain.model.CompanyDTO

interface DBApi {
    fun insertCompany(companies: List<CompanyDTO>)
    fun deleteCompany()
    fun getCompany(): List<CompanyDTO>
}