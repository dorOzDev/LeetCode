package leetcode.augustcontest

import leetcode.utils.Util
import leetcode.augustcontest.PathSum3.TreeNode

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