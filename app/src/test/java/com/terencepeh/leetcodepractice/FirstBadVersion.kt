package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 31/10/22.
 */

var bad = 0

fun isBadVersion(version: Int): Boolean {
    return version == bad
}

// O(LogN)
fun firstBadVersion(n: Int): Int {
    var left = 1
    var right = n

    while (left < right) {
        val mid = left + (right - left) / 2

        if (isBadVersion(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return left
}

fun main() {
    var n = 5
    bad = 4

    println(firstBadVersion(n))

    n = 1
    bad = 1

    println(firstBadVersion(n))
}
