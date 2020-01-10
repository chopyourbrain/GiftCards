package com.example.feature_giftcards_impl.presentation.fragments.main

import androidx.lifecycle.MutableLiveData

interface FragmentMainViewModel {
    fun getCardList()
    val list: MutableLiveData<com.example.core_utils.domain.model.Outcome<List<com.example.core_utils.domain.model.CompanyDTO?>>>
}