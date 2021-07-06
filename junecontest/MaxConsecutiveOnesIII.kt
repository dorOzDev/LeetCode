package leetcode.junecontest

class MaxConsecutiveOnesIII {

    fun longestOnes(nums: IntArray, k: Int): Int {

        if(k == nums.size) return nums.size

        var maxWindowSize = 0
        var currWindowSize = 0
        var startWindow = 0

        var currFlippingCount = k

        for(endWindow in nums.indices) {
            if(nums[endWindow] == 0) {

            }
        }

        return 0
    }
}