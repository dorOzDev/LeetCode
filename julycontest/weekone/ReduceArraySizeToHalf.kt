package leetcode.julycontest.weekone

import java.util.*
import kotlin.Comparator


fun main() {
    val arr = intArrayOf(3,3,3,3,5,5,5,2,2,7)

    ReduceArraySizeToHalf().minSetSize(arr)
}
class ReduceArraySizeToHalf {

    fun minSetSize(arr: IntArray): Int {

        val map = mutableMapOf<Int, Int>()

        for(elem in arr) {
            val newVal = map[elem]?.plus(1) ?: 1
            map[elem] = newVal
        }

        val list = map.toList().sortedByDescending { (_, value) -> value }
        val total = arr.size
        var curr = total
        var countDeletion = 0

        for((_, value) in list) {
            if(curr <= total / 2) return countDeletion
            curr -= value
            countDeletion++
        }

        return countDeletion
    }

/*    class MyTree {

        private val treeSet = TreeSet<Node>(MyComparator())

        fun add(value: Int) {
            if(treeSet.contains())
            val node = treeSet.contains(value)
        }
    }

    class MyComparator : Comparator<Node> {

        override fun compare(o1: Node, o2: Node): Int {

            if(o1.count > o2.count) return -1

            return 1
        }
    }

    data class Node(val value: Int, val count: Int)*/
}