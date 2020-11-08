package com.example.core_network_impl.service

import com.example.core_utils.domain.model.MainDTO
import retrofit2.http.GET

interface MainService {

    @GET("db")
    fun getCards(): MainDTO?
}