package com.example.core_network_impl.data

import com.example.core_network_api.data.HttpClientApi
import com.example.core_network_impl.mock.MockResponse
import com.example.core_network_impl.service.MainService
import com.example.core_utils.domain.model.MainDTO
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

class HttpClientImpl @Inject constructor(retrofit: Retrofit) : HttpClientApi {

    private val service = retrofit.create(MainService::class.java)

    override fun getCards(): Single<MainDTO?> = MockResponse.getCardResponse()//service.getCards()

}