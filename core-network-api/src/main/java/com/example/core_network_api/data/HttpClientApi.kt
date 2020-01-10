package com.example.core_network_api.data

import com.example.core_utils.domain.model.MainDTO
import io.reactivex.Single

interface HttpClientApi {
    fun getCards(): Single<MainDTO?>
}