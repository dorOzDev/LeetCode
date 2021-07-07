package leetcode.julycontest.weekone

import java.util.*

fun main() {

    val matrix: Array<IntArray> = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 2),
    )

    val k = 2

    print(KthSmallestElement().kthSmallest(matrix, k))
}
class KthSmallestElement {

    private lateinit var matrix: Array<IntArray>
    private var n: Int = 0
    private val treeSet = TreeMap<Int, MutableSet<Indices>>()


    private val adjacencyArr = arrayOf(
        arrayOf(1, 0),
        arrayOf(0, 1))

    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        this.matrix = matrix
        this.n = matrix.size
        val visited = Array<BooleanArray>(n){ BooleanArray(n) }
        var count = 0

        treeSet[matrix[0][0]] = mutableSetOf(Indices(0, 0))
        var currNode = treeSet.firstEntry()

        while(count < k) {
            currNode = treeSet.firstEntry()
            count += currNode.value.size
            treeSet.remove(currNode.key)
            addAdjacency(currNode.value, visited)
        }

        val indices = currNode.value.first()
        return matrix[indices.x][indices.y]
    }


    private fun addAdjacency(set: Set<Indices>, visited: Array<BooleanArray>) {

        for(indices in set) {
            for(adj in adjacencyArr) {
                val nextRow = indices.x + adj[0]
                val nextCol = indices.y + adj[1]
                if(nextRow < n && nextCol < n && !visited[nextRow][nextCol]) {
                    val nextSet = treeSet[matrix[nextRow][nextCol]] ?: mutableSetOf()
                    nextSet.add(Indices(nextRow, nextCol))
                    treeSet[matrix[nextRow][nextCol]] = nextSet
                    visited[nextRow][nextCol] = true
                }
            }
        }
    }

    data class Indices(val x: Int, val y: Int)
}