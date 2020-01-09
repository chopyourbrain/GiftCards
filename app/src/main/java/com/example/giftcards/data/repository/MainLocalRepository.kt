package com.example.giftcards.data.repository

import com.example.giftcards.data.source.local.AppRoomDB
import com.example.giftcards.domain.model.CompanyDTO
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainLocalRepository @Inject constructor(appRoomDB: AppRoomDB) {

    private val dao = appRoomDB.companyDao()

    fun saveCompany(list: List<CompanyDTO>) {
        Completable.fromAction {
            dao.deleteCompany()
            dao.insertCompany(list)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            .dispose()
    }

    fun getCompany() = dao.getCompany()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}