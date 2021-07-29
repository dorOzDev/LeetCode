package leetcode.julycontest.weekfive

import java.util.*


fun main() {

    val matrix = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(1, 1, 1)
    )

    println(Matrix01().updateMatrix(matrix))
}
class Matrix01 {

    private val adjacencyArray: Array<MyPair> = arrayOf(
        MyPair(1, 0),
        MyPair(-1, 0),
        MyPair(0, 1),
        MyPair(0, -1))

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {

        val ans = Array<IntArray>(mat.size){ IntArray(mat[0].size) { 0 } }

        for((i, arr) in mat.withIndex()) {
            for((j, _) in arr.withIndex()) {
                ans[i][j] = bfs(mat, i, j)
            }
        }
        return ans
    }

    private fun bfs(mat: Array<IntArray>, x: Int, y: Int): Int {

        val visited = Array<BooleanArray>(mat.size){ BooleanArray(mat[0].size) { false } }
        val queue = LinkedList<MyNode>()

        queue.push(MyNode(x, y, steps = 0))

        while(queue.isNotEmpty()) {
            val node = queue.pop()

            visited[node.x][node.y] = true
            if(mat[node.x][node.y] == 0) return  node.steps

            for(adj in adjacencyArray) {
                val newX = adj.x + node.x
                val newY = adj.y + node.y
                if(isValid(mat.size, mat[0].size, newX, newY) && !visited[newX][newY]) {
                    queue.add(MyNode(newX, newY, node.steps + 1))
                }
            }
        }

        return - 1
    }

    private fun isValid(rowSize: Int, colSize: Int, x: Int, y: Int) =
        (x in 0 until rowSize) && (y in 0 until colSize)

    data class MyNode(val x: Int, val y: Int, val steps: Int)

    data class MyPair(val x: Int, val y: Int)
}