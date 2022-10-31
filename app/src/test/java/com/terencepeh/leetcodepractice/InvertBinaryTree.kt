package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 26/10/22.
 */

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }

    val temp = root.left
    root.left = invertTree(root.right)
    root.right = invertTree(temp)

    return root
}

fun main() {
    val root = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        right = TreeNode(7).apply {
            left = TreeNode(6)
            right = TreeNode(9)
        }
    }

    print(root)
    println()
    print(invertTree(root))
}

fun printPreOrder(node: TreeNode?) {
    if (node == null) {
        return
    }
    print(node.`val`)
    printPreOrder(node.left)
    printPreOrder(node.right)
}

fun print(node: TreeNode?) {
    if (node == null) {
        return
    }
    print(node.`val`)
    printHelper(node)
    println()
}

fun printHelper(node: TreeNode?) {
    if (node == null) {
        return
    }
    if (node.left != null) {
        print(node.left?.`val`)
    }
    if (node.right != null) {
        print(node.right?.`val`)
    }

    printHelper(node.left)
    printHelper(node.right)
}
