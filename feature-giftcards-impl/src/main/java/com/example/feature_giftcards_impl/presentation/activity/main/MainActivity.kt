package com.example.feature_giftcards_impl.presentation.activity.main

import android.os.Bundle
import com.example.feature_giftcards_impl.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        GiftCardsFeatureComponent.get()?.inject(this)
        setContentView(R.layout.activity_main)
    }
}
