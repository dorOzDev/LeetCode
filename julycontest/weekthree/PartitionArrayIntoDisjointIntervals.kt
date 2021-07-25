package leetcode.julycontest.weekthree

import kotlin.math.max

class PartitionArrayIntoDisjointIntervals {

    fun partitionDisjoint(nums: IntArray): Int {

        var partition = 0
        var localMax = nums[partition]
        var globalMax = localMax

        for((index, elem) in nums.withIndex()) {
            if(elem < localMax) {
                if(localMax < globalMax) {
                    localMax = globalMax
                }
                partition = index
            }
            else {
                globalMax = max(globalMax, elem)
            }
        }

        return partition + 1
    }
}