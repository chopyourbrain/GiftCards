package com.example.giftcards

import com.example.giftcards.presentation.activity.main.MainActivity

object MainScreen : KScreen<MainScreen>() {
    override val layoutId: Int? = R.layout.activity_main
    override val viewClass: Class<*>? = MainActivity::class.java


}