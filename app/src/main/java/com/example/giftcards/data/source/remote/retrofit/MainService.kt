package com.example.giftcards.data.source.remote.retrofit

import com.example.giftcards.domain.model.MainDTO
import io.reactivex.Single
import retrofit2.http.GET

interface MainService {

    @GET("db")
    fun getCards(): Single<MainDTO?>
}