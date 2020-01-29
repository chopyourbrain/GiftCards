package com.example.giftcards.screen

import android.view.View
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.swiperefresh.KSwipeRefreshLayout
import com.agoda.kakao.text.KTextView
import com.example.giftcards.R
import com.example.giftcards.presentation.fragments.main.FragmentMain
import com.example.giftcards.screen.base.KScreen
import org.hamcrest.Matcher

object MainScreen : KScreen<MainScreen>() {
    override val layoutId: Int? = R.layout.fragment_main
    override val viewClass: Class<*>? = FragmentMain::class.java
    val recycler = KRecyclerView({ withId(R.id.recycler) }, { itemType(::Company) })
    val swipeRefresh = KSwipeRefreshLayout { withId(R.id.swipe_to_refresh) }
}

class Company(parent: Matcher<View>) : KRecyclerItem<Company>(parent) {
    val title = KTextView(parent) { withId(R.id.title) }
    val cardRecycler = KRecyclerView(parent, { withId(R.id.card_recycler) }, { itemType(::Card) })
}

class Card(parent: Matcher<View>) : KRecyclerItem<Company>(parent) {
    val credits = KTextView(parent) { withId(R.id.credits) }
}