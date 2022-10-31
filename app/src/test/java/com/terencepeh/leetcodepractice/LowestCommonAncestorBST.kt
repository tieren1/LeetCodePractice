package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 26/10/22.
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }

    val current = root.`val`
    val pVal = p!!.`val`
    val qVal = q!!.`val`

    if (pVal > current && qVal > current) {
        return lowestCommonAncestor(root.right, p, q)
    }
    if (pVal < current && qVal < current) {
        return lowestCommonAncestor(root.left, p, q)
    }

    return root
}

fun lowestCommonAncestor2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }

    var node = root
    val pVal = p!!.`val`
    val qVal = q!!.`val`

    while (node != null) {
        node = if (pVal > node.`val` && qVal > node.`val`) {
            node.right
        } else if (pVal < node.`val` && qVal < node.`val`) {
            node.left
        } else {
            break
        }
    }

    return node
}

fun main() {
    val input = TreeNode(6).apply {
        left = TreeNode(2).apply {
            left = TreeNode(0)
            right = TreeNode(4).apply {
                left = TreeNode(3)
                right = TreeNode(5)
            }
        }
        right = TreeNode(8).apply {
            left = TreeNode(7)
            right = TreeNode(9)
        }
    }

    print(input)

    var p = TreeNode(2)
    var q = TreeNode(8)

    println(lowestCommonAncestor(input, p, q)?.`val`)

    p = TreeNode(2)
    q = TreeNode(4)

    println(lowestCommonAncestor2(input, p, q)?.`val`)

    p = TreeNode(2)
    q = TreeNode(1)

    println(lowestCommonAncestor(input, p, q)?.`val`)
}
