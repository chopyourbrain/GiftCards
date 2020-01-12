package com.example.core_db_impl.data

import com.example.core_db_api.data.DBApi
import com.example.core_utils.domain.model.CompanyDTO
import io.reactivex.Single
import javax.inject.Inject

class DBApiImpl @Inject constructor(private val db: AppRoomDB) : DBApi {

    override fun insertCompany(companies: List<CompanyDTO>) {
        db.companyDao().insertCompany(companies)
    }

    override fun deleteCompany() {
        db.companyDao().deleteCompany()
    }

    override fun getCompany(): Single<List<CompanyDTO>> = db.companyDao().getCompany()

}