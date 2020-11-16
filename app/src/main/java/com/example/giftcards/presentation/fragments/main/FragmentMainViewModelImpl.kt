package com.example.giftcards.presentation.fragments.main

import androidx.lifecycle.*
import com.example.core_utils.domain.model.CompanyDTO
import com.example.core_utils.domain.model.Outcome
import com.example.giftcards.domain.usecase.GetCardsUseCase
import com.example.giftcards.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentMainViewModelImpl @Inject constructor(private val getCardsUseCase: GetCardsUseCase) :
    BaseViewModel(),
    FragmentMainViewModel {

    override val list: MutableLiveData<Outcome<List<CompanyDTO?>>> = MutableLiveData()

    init {
        getCardList()
    }

    override fun getCardList() {
        viewModelScope.launch {
            list.value = Outcome.loading(true)
            getCardsUseCase.execute(
                onSuccess = {
                    launch { it.collect { list.value = Outcome.success(it) } }
                }
            ) {
                list.value = Outcome.failure(it)
            }
        }
    }

}
