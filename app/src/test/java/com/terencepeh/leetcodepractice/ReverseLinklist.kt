package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 10/5/22.
 */

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var head: Int) {
    var next: ListNode? = null
}

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    var i = 0

    while (curr != null) {
        print("\nLoop ${++i} - ")
        print("head ${curr.head} : ")

        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next

        print("curr ${curr?.head} -> ")
        print("prev ${prev.head} -> ")
        print("next ${next?.head} -> ")
    }

    return prev
}

// prints content of double linked list
fun printList(head: ListNode?) {
    var node: ListNode? = head
    while (node != null) {
        print(node.head.toString() + " ")
        node = node.next
    }
}

fun main() {
    var linkedList: ListNode? = ListNode(1)
    linkedList?.next = ListNode(2)
    linkedList?.next?.next = ListNode(3)
    linkedList?.next?.next?.next = ListNode(4)

    println("Given Linked list")
    printList(linkedList)
    linkedList = reverseList(linkedList)
    println("\nReversed linked list ")
    printList(linkedList)
}
