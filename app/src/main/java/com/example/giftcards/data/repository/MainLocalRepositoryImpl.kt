package com.example.giftcards.data.repository

import com.example.core_db_api.data.DBApi
import com.example.core_utils.domain.model.CompanyDTO
import com.example.giftcards.domain.repository.MainLocalRepository
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainLocalRepositoryImpl @Inject constructor(private val dbApi: DBApi): MainLocalRepository {

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

    override fun getLocalCardList() = dbApi.getCompany()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}