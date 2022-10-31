package com.terencepeh.leetcodepractice

// O(NKlogK)
// O(NK)
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) {
        return emptyList()
    }

    val hashMap = hashMapOf<String, MutableList<String>>()

    for (s in strs) {
        val ca = s.toCharArray()
        ca.sort()
        val key = String(ca)
        if (!hashMap.containsKey(key)) {
            hashMap[key] = arrayListOf()
        }

        hashMap[key]!!.add(s)
    }

    return ArrayList(hashMap.values)
}

fun matchAnagrams(strs: Array<String>, originalWord: String): List<String> {
    if (originalWord.isBlank()) {
        return emptyList()
    }

    val input = originalWord.toCharArray()
    input.sort()
    val inputKey = String(input)

    val hashMap = hashMapOf<String, MutableList<String>>()

    for (s in strs) {
        val ca = s.toCharArray()
        ca.sort()
        val key = String(ca)
        if (!hashMap.containsKey(key)) {
            hashMap[key] = arrayListOf()
        }

        hashMap[key]!!.add(s)
    }

    return hashMap[inputKey] ?: emptyList()
}

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

    println("groupAnagrams result: ${groupAnagrams(strs)}")
    println("matchAnagrams result: ${matchAnagrams(strs, "ant")}")
}
