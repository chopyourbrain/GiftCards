package com.example.core_network_impl.data

import com.example.core_network_api.data.HttpClientApi
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

class HttpClientImpl @Inject constructor(retrofit: Retrofit) : HttpClientApi {

    override fun getCards(): Single<Object?> {

    }

}