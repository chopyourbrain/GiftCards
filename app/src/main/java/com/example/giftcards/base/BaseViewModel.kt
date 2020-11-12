package com.example.giftcards.base

import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private var thread: Thread? = null

    fun runOnBackgroundThread(lambda: () -> Unit) {
        thread?.interrupt()
        thread = Thread { lambda.invoke() }
        thread?.start()
    }

    fun stopBackgroundThread() {
        thread?.interrupt()
    }

}