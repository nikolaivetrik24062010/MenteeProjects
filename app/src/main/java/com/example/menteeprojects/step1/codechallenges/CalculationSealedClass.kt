package com.example.menteeprojects.step1.codechallenges

sealed class CalculationSealedClass() {
    data class Plus(val a: Int, val b: Int) : CalculationSealedClass()
    data class Minus(val a: Int, val b: Int) : CalculationSealedClass()
    data class Divide(val a: Int, val b: Int) : CalculationSealedClass()
    data class Multiply(val a: Int, val b: Int) : CalculationSealedClass()
}

fun calculate(operation: CalculationSealedClass): Int {
    return when (operation) {
        is CalculationSealedClass.Multiply -> operation.a * operation.b
        is CalculationSealedClass.Plus -> operation.a + operation.b
        is CalculationSealedClass.Minus -> operation.a - operation.b
        is CalculationSealedClass.Divide -> {
            if (operation.b == 0) throw IllegalArgumentException("Division by zero")
            operation.a / operation.b
        }
    }
}

fun main() {
    val add = CalculationSealedClass.Plus(3, 9)
    val minus = CalculationSealedClass.Minus(3, 9)
    val multiply = CalculationSealedClass.Multiply(3, 9)
    val divide = CalculationSealedClass.Divide(3, 9)
    val divideToZero = CalculationSealedClass.Divide(3, 0)
    println(calculate(add))
    println(calculate(minus))
    println(calculate(multiply))
    println(calculate(divide))
    println(calculate(divideToZero))
}