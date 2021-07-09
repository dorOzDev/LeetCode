package leetcode.julycontest.weektwo

import java.util.*
import kotlin.math.max


fun main(args: Array<String>) {
    val arr = intArrayOf(10,9,2,5,3,7,101,18)

    print(LongestIncreasingSubsequence().lengthOfLIS(arr))
}

class LongestIncreasingSubsequence {

    fun lengthOfLIS(nums: IntArray): Int {

        val tree = TreeSet<Int>()

        for(num in nums) {
            val higher = tree.higher(num)

            if(higher == null) tree.add(num)

            else if(!tree.contains(num)){
                tree.remove(higher)
                tree.add(num);
            }
        }

        return tree.size
    }
}