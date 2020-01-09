package com.example.core_network_api.di

import com.example.core_network_api.data.HttpClientApi

interface CoreNetworkApi {
    fun httpClientApi(): HttpClientApi
}