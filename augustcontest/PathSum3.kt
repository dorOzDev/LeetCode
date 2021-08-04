package leetcode.augustcontest

import leetcode.utils.Util
import leetcode.augustcontest.PathSum3.TreeNode

fun main() {

    val test = listOf<Int>(0, 1, 2, 3)

    val root = TreeNode(1)
    val left = TreeNode(2)
    val right = TreeNode(3)
    val targetSum = 3

    root.left = left
    root.right = right

    val list = PathSum3().pathSum(root, targetSum)

    for(innerList in list) {
        print(innerList)
    }
}
class PathSum3 {

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {

        val ans = mutableListOf<List<Int>>()
        pathSumHelper(root, targetSum, 0, ans, emptyList())
        return ans
    }

    private fun pathSumHelper(
        node: TreeNode?,
        targetSum: Int,
        currSum: Int,
        allPaths: MutableList<List<Int>>,
        currPath: List<Int>) {

        if(node == null) return

        if(node.left == null && node.right == null) {
            if(currSum + node.`val` == targetSum)  allPaths.add(currPath.toList() + node.`val`)
        }

        val updatedSum = currSum + node.`val`
        pathSumHelper(node.left, targetSum, updatedSum, allPaths, currPath.toList() + node.`val`)
        pathSumHelper(node.right, targetSum, updatedSum, allPaths, currPath.toList() + node.`val`)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}