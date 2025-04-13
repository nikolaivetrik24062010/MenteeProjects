package com.example.menteeprojects.step1

class Box<T>(private var item: T) {
    fun get(): T = item
    fun set(value: T) {
        item = value
    }
}

fun printBox(box: Box<out Number>) {
    val item = box.get()
    println("Item in the box: $item")
}

fun addIt(box: Box<in String>) {
    box.set("New value")
}