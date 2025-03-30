package com.example.menteeprojects

class Stack<T> {
    private val elements = mutableListOf<T>()
    fun push(item: T) {
        elements.add(item)
    }

    fun pop(): T {
        if (elements.isEmpty()) throw NoSuchElementException("Stack is empty")
        return elements.removeAt(elements.size - 1)
    }

    fun peek(): T {
        if (elements.isEmpty()) throw NoSuchElementException("Stack is empty")
        return elements.last()
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

}