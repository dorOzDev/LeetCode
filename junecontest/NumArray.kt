package leetcode.junecontest

import java.lang.Integer.max
import java.lang.Integer.min


fun main() {
    val segTree = NumArray(intArrayOf(1, 2, 3, 4))

    segTree.update(1, 4)

    println(segTree.sumRange(1, 2))
}
class NumArray(val arr: IntArray) {

    private val segTree: Array<Int> = Array(2 * arr.size) { 0 }
    init {
        buildTree(0, 0, arr.size - 1)
    }

    private fun buildTree(vertex: Int, treeLeft: Int, treeRight: Int) {

        if(treeLeft == treeRight)
            segTree[vertex] = arr[treeLeft]

        else {
            val mid = (treeLeft + treeRight) / 2
            val left = getLeftChildIndex(vertex)
            val right = getRightChild(vertex, mid, treeLeft)

            buildTree(left, treeLeft, mid)
            buildTree(right, mid + 1, treeRight)
            segTree[vertex] = segTree[left] + segTree[right]
        }
    }

    private fun getRightChild(vertex: Int, mid: Int, treeLeft: Int) =
        vertex + 2 * (mid - treeLeft + 1)

    private fun getLeftChildIndex(vertex: Int) =
        vertex + 1


    fun update(index: Int, newValue: Int) {

        arr[index] = newValue
        updateSegTreeHelper(0, 0, arr.size - 1, index, newValue)
    }

    private fun updateSegTreeHelper(vertex: Int, leftBoundary: Int, rightBoundary: Int, position: Int, newValue: Int) {

        if(rightBoundary == leftBoundary) {
            segTree[vertex] = newValue
        }
        else {
            val mid = (leftBoundary + rightBoundary) / 2
            val left = getLeftChildIndex(vertex)
            val right = getRightChild(vertex, mid, leftBoundary)

            if(position <= mid) {
                updateSegTreeHelper(left, leftBoundary, mid, position, newValue)
            }
            else {
                updateSegTreeHelper(right, mid + 1, rightBoundary, position, newValue)
            }

            segTree[vertex] = segTree[left] + segTree[right]
        }
    }

    fun sumRange(left: Int, right: Int) =
        getSumRangeHelper(0, 0, arr.size - 1, left, right)

    private fun getSumRangeHelper(vertex: Int, leftBoundary: Int, rightBoundary: Int, leftQuery: Int, rightQuery: Int): Int {

        if(leftQuery > rightQuery) return 0

        if(leftQuery == leftBoundary && rightQuery == rightBoundary) return segTree[vertex]

        val mid = (leftBoundary + rightBoundary) / 2
        val left = getLeftChildIndex(vertex)
        val right = getRightChild(vertex, mid, leftBoundary)

        return getSumRangeHelper(left, leftBoundary, mid, leftQuery, min(rightQuery, mid)) +
                getSumRangeHelper(right, mid + 1, rightBoundary, max(leftQuery, mid + 1), rightQuery)
    }
}