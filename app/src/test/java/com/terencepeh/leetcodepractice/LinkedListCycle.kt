package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 27/10/22.
 */

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head?.next?.next

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            return true
        }
    }
    return false
}

fun main() {
    val input = ListNode(3).apply {
        val listNode2 = ListNode(2)
        next = listNode2.apply {
            next = ListNode(0).apply {
                next = ListNode(-4).apply {
                    next = listNode2
                }
            }
        }
    }

    val input2 = ListNode(1)
    input2.apply {
        next = ListNode(2).apply {
            next = input2
        }
    }

    val input3 = ListNode(1)

    println(hasCycle(input))
    println(hasCycle(input2))
    println(hasCycle(input3))
}
