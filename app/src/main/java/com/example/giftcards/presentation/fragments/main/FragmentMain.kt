package com.example.giftcards.presentation.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core_utils.util.extensions.hideProgressDialog
import com.example.core_utils.util.extensions.showError
import com.example.core_utils.util.extensions.waitForTransition
import com.example.giftcards.R
import dagger.android.support.DaggerFragment
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        waitForTransition(recycler)
        viewModel.list.observe(viewLifecycleOwner, Observer {
            when (it) {
                is com.example.core_utils.domain.model.Outcome.Progress -> swipe_to_refresh.isRefreshing = true
                is com.example.core_utils.domain.model.Outcome.Success -> {
                    hideProgressDialog()
                    recycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                    recycler.adapter =
                        context?.let { it1 ->
                            com.example.giftcards.presentation.adapters.MainAdapter(
                                it.data.filterNotNull(),
                                it1,
                                this
                            )
                        }
                    swipe_to_refresh.isRefreshing = false
                }
                is com.example.core_utils.domain.model.Outcome.Failure -> {
                    hideProgressDialog()
                    showError(it.e.message.toString())
                    swipe_to_refresh.isRefreshing = false
                }
            }
        })
        swipe_to_refresh.setOnRefreshListener { viewModel.getCardList() }
    }

    override fun navigateToDetail(
        cardDTO: com.example.core_utils.domain.model.CardDTO,
        card: CardView
    ) {
        val bundle = Bundle()
        bundle.putSerializable("cardDTO", cardDTO)
        findNavController().navigate(R.id.fragmentDetail, bundle, null, FragmentNavigatorExtras(card to cardDTO.id.toString()))
    }

}
