package leetcode.julycontest.weektwo

import java.util.*
import kotlin.Comparator

class FindMedianFromDataStream {

    private val leftHeap = PriorityQueue<Int>(ReverseComparator())
    private val rightHeap = PriorityQueue<Int>()
    private var total = 0


    fun addNum(num: Int) {
        when {
            total == 0 -> {
                leftHeap.add(num)
            }

            total % 2 == 0 -> {
                rightHeap.add(num)
                leftHeap.add(rightHeap.remove())
            }

            else -> {
                leftHeap.add(num)
                rightHeap.add(leftHeap.remove())
            }
        }

        total++
    }

    fun findMedian(): Double {

        val left = leftHeap.first().toDouble()
        if(total % 2 == 0) return ((left + rightHeap.first()) / 2)

        return left
    }

    class ReverseComparator : Comparator<Int> {

        override fun compare(o1: Int, o2: Int): Int {
            return o2.compareTo(o1)
        }
    }
}