package com.example.menteeprojects.codechallenges.dsa

import kotlin.text.iterator

fun firstUniqueChar(s: String): Char {
    val freqMap = mutableMapOf<Char, Int>()
    for (ch in s) {
        freqMap[ch] = freqMap.getOrDefault(ch, 0) + 1
    }
    for (ch in s) {
        if (freqMap[ch] == 1) return ch
    }
    return '-'
}

data class ListNode(
    var value: Int,
    var next: ListNode? = null
)

fun reverseLinkedList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var cur = head
    while (cur != null) {
        val next = cur.next
        cur.next = prev
        prev = cur
        cur = next
    }
    return prev
}

fun findMissingNumber(nums: IntArray): Int {
    val n = nums.size
    val sum = n * (n + 1) / 2
    val actualSum = nums.sum()
    return sum - actualSum
}

fun isBalanced(s: String): Boolean {
    val resStack = ArrayDeque<Char>()
    val pairBracketsMap = mapOf(')' to '(', '}' to '{', ']' to '[')
    for (char in s) {
        if (char in pairBracketsMap.values) {
            resStack.addLast(char)
        } else if (char in pairBracketsMap.keys) {
            if (resStack.isEmpty() || resStack.removeLast() != pairBracketsMap[char]) {
                return false
            }
        }
    }
    return resStack.isEmpty()
}

fun lengthOfLongestSubstring(s: String): Int {
    val window = mutableSetOf<Char>()
    var l = 0
    var maxL = 0
    for (r in s.indices) {
        while (s[r] in window) {
            window.remove(s[l])
            l++
        }
        window.add(s[r])
        maxL = maxOf(window.size, maxL)
    }
    return maxL
}