package leetcode.junecontest

import java.util.*

class NumberOfMatchingSubsequence {

    private val mapCharToIndices = mutableMapOf<Char, TreeSet<Int>>()

    fun numMatchingSubseq(s: String, words: Array<String>): Int {

        var count = 0
        preComputeLettersLocation(s)

        for(word in words) {

            if(isWordInString(word, s)) count++
        }

        return count
    }

    private fun isWordInString(word: String, string: String): Boolean {

        if(word.length > string.length) return false

        var lastIndex = -1
        for(char in word) {
            val treeSet = mapCharToIndices[char]
            if(treeSet != null) {
                val higher = treeSet.higher(lastIndex) ?: return false
                lastIndex = higher
            }
            else return false
        }

        return true
    }

    private fun preComputeLettersLocation(s: String) {

        mapCharToIndices.clear()
        for((index, char) in s.withIndex()) {
            var treeSet = mapCharToIndices[char]
            if(treeSet == null) {
                treeSet = TreeSet<Int>()
                mapCharToIndices[char] = treeSet
            }

            treeSet.add(index)
        }
    }
}