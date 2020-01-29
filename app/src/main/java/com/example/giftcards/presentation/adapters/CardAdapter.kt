package com.example.giftcards.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.core_utils.domain.model.CardDTO
import com.example.core_utils.util.extensions.setImageFromUrl
import com.example.giftcards.R
import com.example.giftcards.presentation.fragments.main.NavigateInterface

class CardAdapter(private val list: List<CardDTO>, private val navigateInterface: NavigateInterface) :
    RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_adapter, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val cardImage: ImageView = itemView.findViewById(R.id.card_image)
        private val codesCount: TextView = itemView.findViewById(R.id.codes_count)
        private val credits: TextView = itemView.findViewById(R.id.credits)
        private val card: CardView = itemView.findViewById(R.id.card)

        fun bind(cardDTO: CardDTO) {
            val codesText = "${"$"}${cardDTO.codesCount.toString()}.00"
            codesCount.text = codesText
            credits.text = cardDTO.credits.toString()
            cardImage.setImageFromUrl(cardDTO.imageUrl ?: "")
            card.transitionName = cardDTO.id.toString()
            card.setOnClickListener { navigateInterface.navigateToDetail(cardDTO, card) }
        }
    }
}