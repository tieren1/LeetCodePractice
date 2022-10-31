package com.terencepeh.leetcodepractice

// O(N)
// O(1)
fun firstUniqChar(s: String): Int {
    val countArray = IntArray(26)

    s.forEach { c ->
        val index = c - 'a'
        countArray[index]++
    }

    s.forEachIndexed { i, c ->
        val index = c - 'a'
        if (countArray[index] == 1) {
            return i
        }
    }

    return -1
}

fun firstUniqChar2(s: String): Int {
    s.forEachIndexed { index, c ->
        if (s.indexOf(c) == s.lastIndexOf(c)) {
            return index
        }
    }
    return -1
}

fun main() {
    var s = "aabbc"

    println("firstUniqChar: ${firstUniqChar(s)}")
    println("firstUniqChar2: ${firstUniqChar2(s)}")

    s = "aabb"

    println("firstUniqChar: ${firstUniqChar(s)}")
    println("firstUniqChar2: ${firstUniqChar2(s)}")
}
