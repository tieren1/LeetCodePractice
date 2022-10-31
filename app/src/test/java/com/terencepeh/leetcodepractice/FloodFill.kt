package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 6/10/22.
 */

// O(n x m), O(1)
fun dfs(image: Array<IntArray>, sr: Int, sc: Int, oldColor: Int, newColor: Int): Array<IntArray> {
    if (sr < 0 || sc < 0 || sr >= image.size || sc >= image[0].size || image[sr][sc] != oldColor) {
        return image
    }
    image[sr][sc] = newColor
    // up
    dfs(image, sr - 1, sc, oldColor, newColor)
    // right
    dfs(image, sr, sc + 1, oldColor, newColor)
    // bottom
    dfs(image, sr + 1, sc, oldColor, newColor)
    // left
    dfs(image, sr, sc - 1, oldColor, newColor)

    return image
}

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    if (image.isEmpty() || image[0].isEmpty() || image[sr][sc] == color) {
        return image
    }

    return dfs(image, sr, sc, image[sr][sc], color)
}

fun main() {
    println("Image 1")

    val image1 = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 1, 1))
    floodFill(image1, 1, 1, 2).forEach {
        println(it.contentToString())
    }

    println("Image 2")

    val image2 = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
    floodFill(image2, 0, 0, 0).forEach {
        println(it.contentToString())
    }

    println("Image 3")

    val image3 = arrayOf(intArrayOf(1, 2, 1, 1), intArrayOf(2, 1, 1, 2), intArrayOf(1, 0, 1, 0))
    floodFill(image3, 1, 2, 3).forEach {
        println(it.contentToString())
    }

    println("Image 4")

    val image4 = arrayOf(intArrayOf(), intArrayOf())
    floodFill(image4, 1, 2, 3).forEach {
        println(it.contentToString())
    }
}
