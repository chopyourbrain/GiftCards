package com.example.giftcards

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.core_utils.domain.model.CompanyDTO
import com.example.core_utils.domain.model.MainDTO
import com.example.giftcards.data.repository.MainLocalRepositoryImpl
import com.example.giftcards.data.repository.MainRemoteRepositoryImpl
import com.example.giftcards.domain.usecase.GetCardsUseCase
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetCardsUseCaseTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val localRepository: MainLocalRepositoryImpl =
        mock { on { getLocalCardList() } doReturn Single.fromCallable { cachedList } }

    private val remoteRepositoryPositive: MainRemoteRepositoryImpl = mock {
        on { getCardList() } doReturn Single.fromCallable {
            MainDTO().apply {
                providers = remoteList
            }
        }
    }

    private val remoteRepositoryNegative: MainRemoteRepositoryImpl = mock {
        on { getCardList() } doReturn Single.error { Throwable("Internet exeption") }
    }

    private val remoteList = listOf(CompanyDTO(), null)

    private val cachedList = listOf(CompanyDTO(), CompanyDTO())

    private lateinit var getCardsUseCase: GetCardsUseCase

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun getCardsUseCaseTestPositive() {
        getCardsUseCase = GetCardsUseCase(localRepository, remoteRepositoryPositive)
        getCardsUseCase.execute(
            { assertEquals(it, remoteList) },
            { error("Callback 'onError' executed") })
    }

    @Test
    fun getCardsUseCaseTestNegative() {
        getCardsUseCase = GetCardsUseCase(localRepository, remoteRepositoryNegative)
        getCardsUseCase.execute({
            verify(
                localRepository,
                times(1)
            ).saveCompany(remoteList.filterNotNull())
            assertEquals(it, cachedList)
        }, { error("Callback 'onError' executed") })
    }

}
