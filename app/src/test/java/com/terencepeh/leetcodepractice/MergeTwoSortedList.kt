package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 7/9/22.
 */

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val resultList = ListNode(-1)
    var tailNode: ListNode? = resultList
    var list1Node = list1
    var list2Node = list2

    while (list1Node != null && list2Node != null) {
        if (list1Node.head < list2Node.head) {
            tailNode?.next = list1Node
            list1Node = list1Node.next
        } else {
            tailNode?.next = list2Node
            list2Node = list2Node.next
        }
        tailNode = tailNode?.next
    }

    if (list1Node != null) {
        tailNode?.next = list1Node
    } else if (list2Node != null) {
        tailNode?.next = list2Node
    }

    return resultList.next
}

fun main() {
    val list1 = ListNode(1)
    list1.next = ListNode(2)
    list1.next?.next = ListNode(4)
    list1.next?.next?.next = ListNode(6)
    list1.next?.next?.next?.next = ListNode(7)
    list1.next?.next?.next?.next?.next = ListNode(8)

    val list2 = ListNode(1)
    list2.next = ListNode(3)
    list2.next?.next = ListNode(4)

    println("Given 2 Linked lists")
    print("list1 = ")
    printList(list1)
    print("\nlist2 = ")
    printList(list2)

    print("\nMerge 2 linked list = ")
    printList(mergeTwoLists(list1, list2))
}
