package com.example.menteeprojects.codechallenges

enum class OrderStatus(val etaInDays: Int) {
    PENDING(1),
    PROCESSING(2),
    SHIPPED(3),
    DELIVERED(0);

    fun printEta() {
        if (etaInDays == 0) {
            println("Delivered")
        } else {
            println("ETA: $etaInDays days")
        }
    }

    fun trackOrder(status: OrderStatus) {
        println("Status: $status")
        status.printEta()
    }
}