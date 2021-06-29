package interviewquestions.array


fun main() {
    val arr = intArrayOf(0, 1, 0, 3, 12)
    MoveZeroes().moveZeroes(arr)
}
class MoveZeroes {

    fun moveZeroes(nums: IntArray): Unit {

        var writeNonZeroIndex = 0

        for(elem in nums){
            if(elem != 0) {
                nums[writeNonZeroIndex] = elem
                writeNonZeroIndex++
            }
        }

        for(i in writeNonZeroIndex until nums.size) {
            nums[i] = 0
        }
    }
}