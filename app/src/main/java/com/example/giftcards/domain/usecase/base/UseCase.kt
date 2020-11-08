package com.example.giftcards.domain.usecase.base

abstract class UseCase<T> {

    internal abstract fun buildUseCaseSingle(): T


    fun execute(
        onSuccess: ((t: T) -> Unit),
        onError: ((t: Throwable) -> Unit),
        onFinished: () -> Unit = {}
    ) {
        try {
            onSuccess.invoke(buildUseCaseSingle())
        } catch (e: Exception) {
            onError.invoke(e)
        } finally {
            onFinished.invoke()
        }
    }
}
