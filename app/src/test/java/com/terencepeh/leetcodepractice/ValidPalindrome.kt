package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 8/9/22.
 */

// o(log(n))
fun isPalindrome(s: String): Boolean {
    val sanitisedS = s.lowercase().replace("[^a-z0-9]".toRegex(), "")
    var left = 0
    var right = s.length - 1

    var result = sanitisedS.isEmpty()

    println("sanitised = $sanitisedS")

    while (left < right) {
        if (!s[left].isLetterOrDigit()) {
            ++left
            continue
        }

        if (!s[right].isLetterOrDigit()) {
            --right
            continue
        }

        result = s[left].lowercase() == s[right].lowercase()

        if (!result) {
            break
        }

        ++left
        --right
    }

    return result
}

fun main() {
    val s1 = "A man, a plan, a canal: Panama"

    if (isPalindrome(s1)) {
        println("s1 is a palindrome")
    } else {
        println("s1 is not a palindrome")
    }

    val s2 = "race a car"

    if (isPalindrome(s2)) {
        println("s2 is a palindrome")
    } else {
        println("s2 is not a palindrome")
    }

    val s3 = " "

    if (isPalindrome(s3)) {
        println("s3 is a palindrome")
    } else {
        println("s3 is not a palindrome")
    }

    val s4 = "aba"

    if (isPalindrome(s4)) {
        println("s4 is a palindrome")
    } else {
        println("s4 is not a palindrome")
    }
}
