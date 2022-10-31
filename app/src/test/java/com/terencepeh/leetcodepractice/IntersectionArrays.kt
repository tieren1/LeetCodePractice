package com.terencepeh.leetcodepractice

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    return nums1.intersect(nums2.toHashSet()).toIntArray()
}

fun intersection2(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = nums1.toHashSet()
    val set2 = nums2.toHashSet()

    return if (set1.size > set2.size) {
        setIntersection(set1, set2)
    } else {
        setIntersection(set2, set1)
    }
}

fun setIntersection(set1: HashSet<Int>, set2: HashSet<Int>): IntArray {
    val output = mutableListOf<Int>()

    set2.forEach { s ->
        if (set1.contains(s)) {
            output.add(s)
        }
    }

    return output.toIntArray()
}

fun main() {
    val nums1 = intArrayOf(4, 9, 5, 1)
    val nums2 = intArrayOf(9, 4, 9, 8, 4)

    println("intersection: ${intersection(nums1, nums2).contentToString()}")
    println("intersection: ${intersection2(nums1, nums2).contentToString()}")
}
