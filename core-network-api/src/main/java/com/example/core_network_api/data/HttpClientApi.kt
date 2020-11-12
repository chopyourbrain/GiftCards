package com.example.core_network_api.data

import com.example.core_utils.domain.model.MainDTO

interface HttpClientApi {
    fun getCards(): MainDTO?
}