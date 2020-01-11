package com.example.feature_giftcards_impl.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_giftcards_impl.R
import com.example.feature_giftcards_impl.presentation.fragments.main.NavigateInterface

class MainAdapter(private val list: List<com.example.core_utils.domain.model.CompanyDTO>, val context: Context, private val navigateInterface: NavigateInterface) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_adapter, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.title)
        private val cardRecycler: RecyclerView = itemView.findViewById(R.id.card_recycler)

        fun bind(companyDTO: com.example.core_utils.domain.model.CompanyDTO) {
            title.text = companyDTO.title
            cardRecycler.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            cardRecycler.adapter =
                CardAdapter(
                    companyDTO.gift_cards.orEmpty().filterNotNull(),
                    navigateInterface
                )
        }
    }
}