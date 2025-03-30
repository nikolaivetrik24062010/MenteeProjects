package com.example.menteeprojects.codechallenges

sealed class NetworkResult {
    data class Success(val data: String) : NetworkResult()
    data class Error(val message: String) : NetworkResult()
    object Loading : NetworkResult()
}

fun simulateNetworkCall(): NetworkResult {
    return when ((0..2).random()) {
        0 -> NetworkResult.Success("Data from server")
        1 -> NetworkResult.Error("Something went wrong")
        else -> NetworkResult.Loading
    }
}

fun handleResult(result: NetworkResult) {
    when (result) {
        is NetworkResult.Success -> println("Success: ${result.data}")
        is NetworkResult.Error -> println("Error: ${result.message}")
        NetworkResult.Loading -> println("Loading...")
    }
}
