package com.example.giftcards.presentation.fragments.main

import androidx.lifecycle.MutableLiveData
import com.example.core_utils.domain.model.CompanyDTO
import com.example.core_utils.domain.model.Outcome

interface FragmentMainViewModel {
    fun getCardList()
    val list: MutableLiveData<Outcome<List<CompanyDTO?>>>
}