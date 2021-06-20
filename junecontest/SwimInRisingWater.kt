package leetcode.junecontest

import com.sun.org.apache.xpath.internal.operations.Bool
import java.lang.Integer.min
import java.util.*
import kotlin.math.max


fun main() {

    val grid = arrayOf(
        intArrayOf(0, 2),
        intArrayOf(1, 3)
    )

    print(SwimInRisingWater().swimInWater(grid))
}
class SwimInRisingWater {

    private val adjArr = arrayOf(
        arrayOf(1, 0),
        arrayOf(-1, 0),
        arrayOf(0, 1),
        arrayOf(0, -1)
    )

    var rowSize: Int = 0
    var colSize: Int = 0

    fun swimInWater(grid: Array<IntArray>): Int {

        rowSize = grid.size
        colSize = grid[0].size
        val visited = Array<Array<Int>>(rowSize) { Array<Int>(colSize) { Int.MAX_VALUE } }
        val queue = LinkedList<Node>()
        var min = Integer.MAX_VALUE

        queue.add(Node(0, 0, grid[0][0]))

        while(queue.isNotEmpty()) {
            val node = queue.pop()

            for(adj in adjArr) {
                val (preComputeX, preComputeY) = adj
                val x = preComputeX + node.x
                val y = preComputeY + node.y

                if(isValid(x, y) && visited[x][y] > node.elevation) {
                    queue.add(Node(x, y, max(node.elevation, grid[x][y])))
                    visited[x][y] = node.elevation
                }
            }

            if(node.x == rowSize - 1 && node.y == colSize - 1) min = min(min, node.elevation)
        }

        return min
    }

    private fun isValid(x: Int, y: Int): Boolean =
        x in 0 until rowSize && y in 0 until colSize

    data class Node(val x: Int, val y: Int, val elevation: Int)
}