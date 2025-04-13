package com.example.menteeprojects.step1.codechallenges

sealed class ScreenState<out T> {
    object Loading : ScreenState<Nothing>()
    data class Data<T>(val data: T) : ScreenState<T>()
    data class Error(val message: String) : ScreenState<String>()
}

fun <T> renderState(state: ScreenState<T>) {
    when (state) {
        is ScreenState.Loading -> println("Loading...")
        is ScreenState.Data -> println("Data: ${state.data}")
        is ScreenState.Error -> println("Error: ${state.message}")
    }
}