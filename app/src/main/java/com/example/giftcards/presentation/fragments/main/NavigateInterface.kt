package com.example.giftcards.presentation.fragments.main

import androidx.cardview.widget.CardView
import com.example.core_utils.domain.model.CardDTO

interface NavigateInterface {
    fun navigateToDetail(
        cardDTO: CardDTO,
        card: CardView
    )
}