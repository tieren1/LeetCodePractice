package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 7/9/22.
 */

// o(n2)
fun maxProfitBruteForce(prices: IntArray): Int {
    var maxProfit = 0
    for (i in 0 until prices.size - 1) {
        for (j in i until prices.size) {
            val profit = prices[j] - prices[i]
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
    }
    return maxProfit
}

// O(n)
fun maxProfitTwoPointer(prices: IntArray): Int {
    var left = 0
    var right = 1
    var maxProfit = 0

    while (right < prices.size) {
        if (prices[left] < prices[right]) {
            val profit = prices[right] - prices[left]
            maxProfit = kotlin.math.max(maxProfit, profit)
        } else {
            left = right
        }

        right += 1
    }

    return maxProfit
}

fun maxProfit(prices: IntArray): Int {
    var minPrice = Integer.MAX_VALUE
    var maxProfit = 0

    for (i in prices.indices) {
        if (prices[i] < minPrice) {
            minPrice = prices[i]
        } else {
            val profit = prices[i] - minPrice
            maxProfit = kotlin.math.max(maxProfit, profit)
        }
    }

    return maxProfit
}

fun main() {
    val input1 = intArrayOf(7, 1, 5, 3, 6, 4)
    val input2 = intArrayOf(7, 6, 4, 3, 1)

    println("Prices input1 = ${maxProfitBruteForce(input1)}")
    println("Prices input2 = ${maxProfitBruteForce(input2)}")

    println("Prices input1 = ${maxProfitTwoPointer(input1)}")
    println("Prices input2 = ${maxProfitTwoPointer(input2)}")

    println("Prices input1 = ${maxProfit(input1)}")
    println("Prices input2 = ${maxProfit(input2)}")
}
