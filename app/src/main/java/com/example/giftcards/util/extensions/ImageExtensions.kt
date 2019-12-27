package com.example.giftcards.util.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.setImageFromUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .apply(
            RequestOptions()
                .centerCrop()
        )
        .into(this)
}