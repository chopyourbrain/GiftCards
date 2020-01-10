package com.example.feature_giftcards_impl.data.repository

import com.example.core_db_api.data.DBApi
import com.example.core_utils.domain.model.CompanyDTO
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainLocalRepository @Inject constructor(private val dbApi: DBApi) {

    fun saveCompany(list: List<CompanyDTO>) {
        Completable.fromAction {
            dbApi.deleteCompany()
            dbApi.insertCompany(list)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            .dispose()
    }

    fun getCompany() = dbApi.getCompany()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}