package com.example.core_network_impl.service

import com.example.core_utils.domain.model.MainDTO
import io.reactivex.Single
import retrofit2.http.GET

interface MainService {

    @GET("db")
    fun getCards(): Single<MainDTO?>
}