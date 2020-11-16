package com.example.giftcards.domain.usecase.base

abstract class UseCase<T> {

    internal abstract suspend fun buildUseCaseSingle(): T

    suspend fun execute(
        onSuccess: (t: T) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        runCatching {
            buildUseCaseSingle()
        }.onFailure {
            onError.invoke(it)
        }.onSuccess {
            onSuccess.invoke(it)
        }
    }
}
