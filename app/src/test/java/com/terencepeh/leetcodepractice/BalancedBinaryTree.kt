package com.terencepeh.leetcodepractice

import kotlin.math.abs
import kotlin.math.max

/**
 * Created by Terence Peh on 26/10/22.
 */

fun isBalanced(root: TreeNode?): Boolean {
    return dfs(root).first
}

fun dfs(root: TreeNode?): Pair<Boolean, Int> {
    if (root == null) {
        return Pair(true, 0)
    }
    val left = dfs(root.left)
    val right = dfs(root.right)
    val balanced = left.first && right.first && abs(left.second - right.second) <= 1

    return balanced to (1 + max(left.second, right.second))
}

fun main() {
    val input = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    println(isBalanced(input))

    val input2 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3).apply {
                left = TreeNode(4)
                right = TreeNode(4)
            }
            right = TreeNode(3)
        }
        right = TreeNode(2)
    }

    println(isBalanced(input2))
}
