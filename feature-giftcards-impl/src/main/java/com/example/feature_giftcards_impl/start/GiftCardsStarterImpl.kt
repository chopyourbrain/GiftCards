package com.example.feature_giftcards_impl.start

import android.content.Context
import android.content.Intent
import com.example.feature_giftcards_api.GiftCardsStarter
import com.example.feature_giftcards_impl.presentation.activity.main.MainActivity
import javax.inject.Inject

class GiftCardsStarterImpl @Inject constructor(): GiftCardsStarter {

    override fun start(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        context.startActivity(intent)
    }

}