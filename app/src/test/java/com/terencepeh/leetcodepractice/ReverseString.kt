package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 10/5/22.
 */

fun reverseString(s: CharArray) {
    var start = 0
    var end = s.size - 1

    while (start < end) {
        val temp = s[start]
        s[start] = s[end]
        s[end] = temp
        start++
        end--
    }
}

fun main() {
    val input = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g')
    println("Input: ${input.contentToString()}")
    reverseString(input)
    println("Input: ${input.contentToString()}")
}
