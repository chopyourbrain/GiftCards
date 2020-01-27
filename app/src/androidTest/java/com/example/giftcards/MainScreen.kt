package com.example.giftcards

import android.view.View
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KTextView
import com.example.giftcards.presentation.activity.main.MainActivity
import org.hamcrest.Matcher

object MainScreen : KScreen<MainScreen>() {
    override val layoutId: Int? = R.layout.activity_main
    override val viewClass: Class<*>? = MainActivity::class.java
    val recycler = KRecyclerView({ withId(R.id.recycler) }, { itemType(::Company) })
}

class Company(parent: Matcher<View>) : KRecyclerItem<Company>(parent) {
    val title = KTextView(parent) { withId(R.id.title) }
}