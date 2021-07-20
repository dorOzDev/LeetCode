package leetcode.julycontest.weekthree

import leetcode.utils.Util
import kotlin.random.Random


fun main() {

    val arr = intArrayOf(1, 2, 3)
    val shuffle = ShuffleAnArray(arr)

    Util.printArr(shuffle.shuffle())
    Util.printArr(shuffle.reset())
}
class ShuffleAnArray(nums: IntArray) {

    private val origin = nums
    private val shuffledArray = origin.copyOf()

    /** Resets the array to its original configuration and return it. */
    fun reset() = origin


    fun shuffle(): IntArray {

        for(i in origin.size - 1 downTo 0) {
            val randomIndex = (0..i).random()

            shuffledArray.swap(i, randomIndex)
        }

        return shuffledArray
    }
}

fun IntArray.swap(i: Int, j: Int) {

    if((i !in (0 until size)) || (j !in (0 until size))) {
        println("indices provided are out of the array bounds")
        return
    }

    val temp = get(i)
    this[i] = get(j)
    this[j] = temp
}