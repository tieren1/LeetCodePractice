package com.terencepeh.leetcodepractice

import java.util.*

/**
 * Created by Terence Peh on 9/5/22.
 */

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    val map = mapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{'
    )
    s.forEach { c ->
        when {
            stack.empty() -> stack.push(c)
            stack.peek() == map[c] -> stack.pop()
            else -> stack.push(c)
        }
    }
    return stack.empty()
}

fun main() {
    println("isValid result: ${isValid("()")}")
    println("isValid result: ${isValid("[]")}")
    println("isValid result: ${isValid("{()}")}")
    println("isValid result: ${isValid("{([])}")}")
    println("isValid result: ${isValid("{{")}")
    println("isValid result: ${isValid("{)")}")
    println("isValid result: ${isValid(")")}")
    println("isValid result: ${isValid(")(")}")
    println("isValid result: ${isValid("{{}}")}")
}
