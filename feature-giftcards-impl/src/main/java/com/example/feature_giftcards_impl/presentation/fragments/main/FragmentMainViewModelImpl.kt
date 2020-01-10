package com.example.feature_giftcards_impl.presentation.fragments.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feature_giftcards_impl.domain.usecase.GetCardsUseCase
import javax.inject.Inject

class FragmentMainViewModelImpl @Inject constructor(private val getCardsUseCase: GetCardsUseCase) :
    ViewModel(), FragmentMainViewModel {

    override val list: MutableLiveData<com.example.core_utils.domain.model.Outcome<List<com.example.core_utils.domain.model.CompanyDTO?>>> = MutableLiveData()

    init {
        getCardList()
    }

    override fun getCardList() {
        list.postValue(com.example.core_utils.domain.model.Outcome.loading(true))
        getCardsUseCase.execute(
            onSuccess = {
                list.postValue(com.example.core_utils.domain.model.Outcome.success(it))
            },
            onError = {
                list.postValue(com.example.core_utils.domain.model.Outcome.failure(it))
            })
    }
}
