package com.example.giftcards.presentation.fragments.main

import androidx.lifecycle.*
import com.example.core_utils.domain.model.CompanyDTO
import com.example.core_utils.domain.model.Outcome
import com.example.giftcards.domain.usecase.GetCardsUseCase
import com.example.giftcards.base.BaseViewModel
import javax.inject.Inject

class FragmentMainViewModelImpl @Inject constructor(private val getCardsUseCase: GetCardsUseCase) :
    BaseViewModel(),
    FragmentMainViewModel, LifecycleObserver {

    override val list: MutableLiveData<Outcome<List<CompanyDTO?>>> = MutableLiveData()

    init {
        getCardList()
    }

    override fun getCardList() {
        runOnBackgroundThread {
            list.value = Outcome.loading(true)
            getCardsUseCase.execute(
                onSuccess = {
                    list.value = Outcome.success(it)
                },
                onError = {
                    list.value = Outcome.failure(it)
                })
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        stopBackgroundThread()
    }

}
