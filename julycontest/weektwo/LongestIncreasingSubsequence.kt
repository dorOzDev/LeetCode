package leetcode.julycontest.weektwo

import java.util.*
import kotlin.math.max


fun main(args: Array<String>) {
    val arr = intArrayOf(10,9,2,5,3,7,101,18)

    print(LongestIncreasingSubsequence().lengthOfLIS(arr))
}
class LongestIncreasingSubsequence {

    fun lengthOfLIS(nums: IntArray): Int {

        val tree = TreeMap<Int, Int>()
        var max = 0
        for(num in nums) {
            var lower = tree.lowerEntry(num)
            var localMax = 1
            while (lower != null) {
                localMax = max(lower.value + 1, localMax)
                lower = tree.lowerEntry(lower.key)
            }

            tree[num] = localMax
            max = max(max, localMax)
        }

        return max
    }
}