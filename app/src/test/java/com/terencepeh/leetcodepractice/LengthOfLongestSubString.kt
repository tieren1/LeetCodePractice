package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 10/6/22.
 */

// O(n)
// O(n)
fun lengthOfLongestSubstring(s: String): Int {
    val map = hashMapOf<Char, Int>()
    var left = 0
    var len = 0

    for (i in s.indices) {
        val c = s[i]

        if (map.containsKey(c)) {
            left = left.coerceAtLeast(map[c]!! + 1)
        }

        len = len.coerceAtLeast(i - left + 1)
        map[c] = i
    }

    return len
}

fun main() {
    var input = "abcabcbb"
    println(lengthOfLongestSubstring(input))

    input = "bbbbb"
    println(lengthOfLongestSubstring(input))

    input = "pwwkew"
    println(lengthOfLongestSubstring(input))
}
