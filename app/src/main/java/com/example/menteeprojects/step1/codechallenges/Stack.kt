package com.example.menteeprojects.step1.codechallenges

class Stack<T> {
    private val elements = mutableListOf<T>()
    fun push(item: T) {
        elements.add(item)
    }

    fun pop(): T {
        if (elements.isEmpty()) throw NoSuchElementException("Stack is empty")
        return elements.removeAt(elements.lastIndex)
    }

    fun peek(): T {
        if (elements.isEmpty()) throw NoSuchElementException("Stack is empty")
        return elements.last()
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

}