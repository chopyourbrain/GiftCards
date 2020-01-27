package com.example.giftcards.di.module

import com.example.giftcards.data.repository.MainLocalRepositoryImpl
import com.example.giftcards.data.repository.MainRemoteRepositoryImpl
import com.example.giftcards.domain.repository.MainLocalRepository
import com.example.giftcards.domain.repository.MainRemoteRepository
import dagger.Binds
import dagger.Module

@Module
abstract class BindingModule {

    @Binds
    abstract fun bindMainLocalRepo(impl: MainLocalRepositoryImpl): MainLocalRepository

    @Binds
    abstract fun bindMainRemoteRepo(impl: MainRemoteRepositoryImpl): MainRemoteRepository

}