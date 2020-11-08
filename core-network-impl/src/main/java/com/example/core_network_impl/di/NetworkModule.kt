package com.example.core_network_impl.di

import com.example.core_network_api.data.HttpClientApi
import com.example.core_network_impl.data.HttpClientImpl
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Module
    companion object {
        @Singleton
        @Provides
        @JvmStatic
        fun provideTransportProvider(): Retrofit {
            val baseUrl = "https://my-json-server.typicode.com/chopyourbrain/GiftCards/"
            val builder = OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)

            return Retrofit.Builder()
                .client(builder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()))
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
        }
    }

    @Binds
    abstract fun provideHttpClient(httpClientImpl: HttpClientImpl): HttpClientApi

}