package com.terencepeh.leetcodepractice

import java.util.*

/**
 * Created by Terence Peh on 27/10/22.
 */

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */

class MyQueue {

    private val stack1 = Stack<Int>()
    private val stack2 = Stack<Int>()

    fun push(x: Int) {
        while (stack1.isNotEmpty()) {
            stack2.push(stack1.pop())
        }
        stack1.push(x)
        while (stack2.isNotEmpty()) {
            stack1.push(stack2.pop())
        }
    }

    fun pop(): Int {
        return stack1.pop()
    }

    fun peek(): Int {
        return stack1.peek()
    }

    fun empty(): Boolean {
        return stack1.isEmpty()
    }
}

fun main() {
    val myQueue = MyQueue()
    myQueue.push(1)
    myQueue.push(2)

    println(myQueue.peek())
    println(myQueue.pop())
    println(myQueue.empty())
}
