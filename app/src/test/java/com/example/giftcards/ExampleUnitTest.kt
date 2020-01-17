package com.example.giftcards

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.core_utils.domain.model.CompanyDTO
import com.example.core_utils.domain.model.Outcome
import com.example.giftcards.domain.usecase.GetCardsUseCase
import com.example.giftcards.presentation.fragments.main.FragmentMainViewModelImpl
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private var getCardsUseCase: GetCardsUseCase =
        mock { on { buildUseCaseSingle() } doReturn Single.fromCallable { list } }

    private val list = listOf(CompanyDTO(), null)

    private val observer: Observer<Outcome<List<CompanyDTO?>>> = mock()

    private lateinit var viewModel:FragmentMainViewModelImpl

    @Before
    fun setup() {
        getCardsUseCase = mock { on { buildUseCaseSingle() } doReturn Single.fromCallable { list } }
        viewModel = FragmentMainViewModelImpl(getCardsUseCase)
        viewModel.list.observeForever(observer)
    }

    @Test
    fun addition_isCorrect() {
        viewModel.getCardList()
        ArgumentCaptor.forClass(Outcome::class.java).run {
            verify(observer, times(1)).onChanged(capture() as? Outcome<List<CompanyDTO?>>)// .list.value = Outcome.success(list)
//            assertEquals(Outcome.loading<Boolean>(true), value)
            assertEquals(list, value)
        }
    }
}
