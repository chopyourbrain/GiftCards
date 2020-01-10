package com.example.core_utils.util.extensions

import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment

fun Fragment.waitForTransition(view: View) {
    postponeEnterTransition()
    view.doOnPreDraw { startPostponedEnterTransition() }
}