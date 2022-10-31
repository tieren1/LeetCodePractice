package com.terencepeh.leetcodepractice

// O(n)
// O(n)
fun twoSums(nums: IntArray, target: Int): IntArray {
    val map: MutableMap<Int, Int> = HashMap()

    for (i in nums.indices) {
        if (map.containsKey(target - nums[i])) {
            val temp = map[target - nums[i]]!!.toInt()
            return intArrayOf(temp, i)
        }

        map[nums[i]] = i
    }

    return intArrayOf()
}

fun main() {
    val input = intArrayOf(2, 7, 9)
    val target = 9
    println("TwoSum result: ${twoSums(input, target).contentToString()}")
}
