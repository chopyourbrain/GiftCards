package com.example.giftcards.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core_utils.domain.model.CompanyDTO
import com.example.giftcards.R
import com.example.giftcards.presentation.fragments.main.FragmentMain
import com.example.giftcards.presentation.fragments.main.NavigateInterface
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter

class MainAdapter(
    private var list: List<CompanyDTO>,
    private val navigateInterface: NavigateInterface
) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun getItemCount(): Int = list.size

    fun setupNewList(list: List<CompanyDTO>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_adapter, parent, false)
        return ViewHolder(itemView).apply { cardRecycler.setRecycledViewPool(viewPool) }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.title)
        val cardRecycler: RecyclerView = itemView.findViewById(R.id.card_recycler)
        private lateinit var layoutManager: LinearLayoutManager
        private var index = -1
        private var offset = -1

        fun bind(companyDTO: CompanyDTO) {
            title.text = companyDTO.title
            layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            cardRecycler.layoutManager = layoutManager
            cardRecycler.adapter = AlphaInAnimationAdapter(
                CardAdapter(
                    companyDTO.giftCards.orEmpty().filterNotNull(),
                    navigateInterface)
            )
        }

        fun savePosition(): FragmentMain.RecyclerPosition {
            index = layoutManager.findFirstVisibleItemPosition()
            offset =
                if (cardRecycler.getChildAt(0) == null) 0 else cardRecycler.getChildAt(0).left - cardRecycler.paddingStart
            return FragmentMain.RecyclerPosition(index, offset)
        }

        fun restorePosition(position: FragmentMain.RecyclerPosition?) {
            position?.let {
                layoutManager.scrollToPositionWithOffset(it.index, it.offset)
            }
        }
    }
}