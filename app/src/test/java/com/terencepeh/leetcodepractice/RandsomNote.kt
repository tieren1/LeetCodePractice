package com.terencepeh.leetcodepractice

/**
 * Created by Terence Peh on 31/10/22.
 */

// O(nxm)
fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val magazineArr = IntArray(26)
    magazine.forEach {
        magazineArr[it - 'a'] += 1
    }
    ransomNote.forEach {
        val index = it - 'a'
        if (magazineArr[index] == 0) {
            return false
        } else {
            magazineArr[index] -= 1
        }
    }

    return true
}

fun main() {
    var ransomNote = "a"
    var magazine = "b"

    println(canConstruct(ransomNote, magazine))

    ransomNote = "aa"
    magazine = "ab"
    println(canConstruct(ransomNote, magazine))

    ransomNote = "aa"
    magazine = "aab"
    println(canConstruct(ransomNote, magazine))
}
