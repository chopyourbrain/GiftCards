package com.example.feature_giftcards_impl.presentation.fragments.main

import androidx.cardview.widget.CardView

interface NavigateInterface {
    fun navigateToDetail(
        cardDTO: com.example.core_utils.domain.model.CardDTO,
        card: CardView
    )
}