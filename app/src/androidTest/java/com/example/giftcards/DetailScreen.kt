package com.example.giftcards

import com.agoda.kakao.text.KTextView
import com.example.giftcards.presentation.fragments.detail.FragmentDetail

object DetailScreen : KScreen<DetailScreen>() {
    override val layoutId: Int? = R.layout.fragment_detail
    override val viewClass: Class<*>? = FragmentDetail::class.java
    val codesCount = KTextView { withId(R.id.codes_count) }
    val credits = KTextView { withId(R.id.credits) }
    val descriprion = KTextView { withId(R.id.description) }
    val redeemUrl = KTextView { withId(R.id.redeem) }
}