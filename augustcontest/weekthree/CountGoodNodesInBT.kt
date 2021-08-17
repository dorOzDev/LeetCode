package leetcode.augustcontest.weekthree

import kotlin.math.max

class CountGoodNodesInBT {

    fun goodNodes(root: TreeNode?) =
        goodNodesHelper(Int.MIN_VALUE, root)

    private fun goodNodesHelper(max: Int, node: TreeNode?): Int {

        if(node == null) {
            return 0
        }

        if(node.left == null && node.right == null) {
            if(node.`val` >= max) {
                return 1
            }
            return 0
        }

        val updatedMax = max(max, node.`val`)
        val visitNode = if(node.`val` >= updatedMax) 1 else 0
        return goodNodesHelper(updatedMax, node.left) + goodNodesHelper(updatedMax, node.right) + visitNode
    }
}

data class TreeNode(var `val`: Int, var left: TreeNode?, var right: TreeNode?)