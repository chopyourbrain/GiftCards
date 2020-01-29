package com.example.giftcards.data

import com.example.core_utils.domain.model.CardDTO

object SmokeTestData {

    val companyList = listOf("Amazon.com", "iTunes", "Steam")

    val firstItem = CardDTO().apply {
        credits = 8500
        codesCount = 101
        description = "Buy everything from Amazon. It's great."
        redeemUrl = "http://www.amazon.com"
    }
}