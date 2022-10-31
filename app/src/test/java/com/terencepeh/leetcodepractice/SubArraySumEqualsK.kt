package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 23/3/22.
 */
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// O(n)
// O(n)
fun subarraySum(nums: IntArray, k: Int): Int {
    var count = 0
    var sum = 0
    val map: HashMap<Int, Int> = HashMap()
    map[0] = 1
    nums.forEach { i ->
        sum += i
        if (map.containsKey(sum - k)) {
            count += map[sum - k]!!
        }
        map[sum] = map.getOrDefault(sum, 0) + 1
    }

    return count
}

fun main() {
    val input = intArrayOf(1, 1, 1)
    val k = 2
    println("subarraySum result: ${subarraySum(input, k)}")

    val input2 = intArrayOf(1, 2, 3)
    val k2 = 3
    println("subarraySum result: ${subarraySum(input2, k2)}")

    data class SomeClass(var someField: Boolean)
    var data: SomeClass? = SomeClass(false)

    println("result: ${data?.someField == false}")

    println("result: ${data != null && !data.someField}")

    data = null

    println("result: ${data?.someField == false}")

    println("result: ${data != null && !data.someField}")
}
