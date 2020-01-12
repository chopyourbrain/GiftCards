package com.example.giftcards.presentation.fragments.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core_utils.domain.model.CompanyDTO
import com.example.core_utils.domain.model.Outcome
import com.example.giftcards.domain.usecase.GetCardsUseCase
import javax.inject.Inject

class FragmentMainViewModelImpl @Inject constructor(private val getCardsUseCase: GetCardsUseCase) :
    ViewModel(),
    FragmentMainViewModel {

    override val list: MutableLiveData<Outcome<List<CompanyDTO?>>> = MutableLiveData()

    init {
        getCardList()
    }

    override fun getCardList() {
        list.postValue(Outcome.loading(true))
        getCardsUseCase.execute(
            onSuccess = {
                list.postValue(Outcome.success(it))
            },
            onError = {
                list.postValue(Outcome.failure(it))
            })
    }
}
