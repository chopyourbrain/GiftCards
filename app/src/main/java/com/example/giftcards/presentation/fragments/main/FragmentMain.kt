package com.example.giftcards.presentation.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.view.doOnPreDraw
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core_utils.domain.model.Outcome
import com.example.core_utils.util.extensions.hideProgressDialog
import com.example.core_utils.util.extensions.showError
import com.example.giftcards.R
import com.example.giftcards.presentation.adapters.MainAdapter
import dagger.android.support.DaggerFragment
import jp.wasabeef.recyclerview.animators.FadeInDownAnimator
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class FragmentMain : DaggerFragment(),
    NavigateInterface {

    companion object {
        fun newInstance() =
            FragmentMain()
    }

    @Inject
    lateinit var viewModel: FragmentMainViewModel

    private lateinit var recyclerViewLayoutManager: LinearLayoutManager

    private var index = -1

    private var offset = -1

    private var recyclersStates = mutableListOf<RecyclerPosition>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewLayoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler.apply {
            layoutManager = recyclerViewLayoutManager
            adapter =
                context?.let { it1 ->
                    MainAdapter(
                        listOf(),
                        this@FragmentMain
                    )
                }
            itemAnimator = FadeInDownAnimator()
        }
        viewModel.list.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Outcome.Progress -> swipe_to_refresh.isRefreshing =
                    true
                is Outcome.Success -> {
                    hideProgressDialog()
                    (recycler.adapter as MainAdapter).setupNewList(it.data.filterNotNull())
                    swipe_to_refresh.isRefreshing = false
                }
                is Outcome.Failure -> {
                    hideProgressDialog()
                    showError(it.e.message.toString())
                    swipe_to_refresh.isRefreshing = false
                }
            }
        })

        postponeEnterTransition()
        view.doOnPreDraw {
            restoreRecyclersState()
            startPostponedEnterTransition()
        }
        swipe_to_refresh.setOnRefreshListener { viewModel.getCardList() }
    }

    override fun navigateToDetail(
        cardDTO: com.example.core_utils.domain.model.CardDTO,
        card: CardView
    ) {
        val bundle = Bundle()
        bundle.putSerializable("cardDTO", cardDTO)
        findNavController().navigate(
            R.id.fragmentDetail,
            bundle,
            null,
            FragmentNavigatorExtras(card to cardDTO.id.toString())
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        saveRecyclersState()
    }

    private fun saveRecyclersState() {
        index = recyclerViewLayoutManager.findFirstVisibleItemPosition()
        offset =
            if (recycler.getChildAt(0) == null) 0 else recycler.getChildAt(0).top - recycler.paddingTop
        for (i in 0 until (recycler.adapter?.itemCount ?: 0)) {
            recyclersStates.add((recycler.findViewHolderForLayoutPosition(i) as MainAdapter.ViewHolder).savePosition())
        }
    }

    private fun restoreRecyclersState() {
        if (index != -1) {
            recyclerViewLayoutManager.scrollToPositionWithOffset(index, offset)
            for (i in 0 until (recycler.adapter?.itemCount ?: 0)) {
                (recycler.findViewHolderForLayoutPosition(i) as MainAdapter.ViewHolder).restorePosition(
                    recyclersStates[i]
                )
            }
            recyclersStates.removeAll { true }
        }
    }

    data class RecyclerPosition(val index: Int, val offset: Int)
}
