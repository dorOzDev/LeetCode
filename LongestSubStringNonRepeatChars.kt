package leetcode

import kotlin.math.max

class LongestSubStringNonRepeatChars {

    private val map = mutableMapOf<Char, Int>()

    fun lengthOfLongestSubstring(s: String): Int {

        var longestSubStr = 0
        var startWindowIndex = 0


        for((endWindowIndex, ch) in s.withIndex()) {
            val lastSeenIndex = map[ch] ?: -1

            if(lastSeenIndex != -1) {
                if(startWindowIndex < lastSeenIndex + 1)
                    startWindowIndex = lastSeenIndex + 1
            }

            longestSubStr = max(longestSubStr, endWindowIndex - startWindowIndex + 1)
            map[ch] = endWindowIndex
        }

        return longestSubStr
    }
}