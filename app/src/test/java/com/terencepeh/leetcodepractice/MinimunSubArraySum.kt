package com.terencepeh.leetcodepractice

import java.lang.Integer.min

/**
 * Created by Terence Peh on 13/5/22.
 */

// O(n)
fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var end = 0
    var sum = 0
    var min = Int.MAX_VALUE

    nums.forEachIndexed { index, num ->
        sum += num
        if (sum >= target) {
            while (sum >= target) {
                min = min(min, index - end + 1)
                sum -= nums[end++]
            }
        }
    }

    return if (min == Int.MAX_VALUE) 0 else min
}

fun main() {
    var target = 7
    var nums = intArrayOf(2, 3, 1, 2, 4, 3)

    println("Min length of sub array ${minSubArrayLen(target,nums)}")

    target = 4
    nums = intArrayOf(1, 4, 4)

    println("Min length of sub array ${minSubArrayLen(target,nums)}")

    target = 11
    nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)

    println("Min length of sub array ${minSubArrayLen(target,nums)}")
}
