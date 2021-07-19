package leetcode.julycontest.weekthree

import java.util.*

class LowestCommonAncestor {


    fun lowestCommonAncestor(root: TreeNode, p: TreeNode?, q: TreeNode?): TreeNode? {

        if(p == null || q == null) return null

        var common: TreeNode? = null
        var itrP = root
        var itrQ = root

        while(itrP == itrQ) {
            common = itrP

            itrP = when {
                itrP.`val` > p.`val` -> itrP.left ?: itrP

                itrP.`val` < p.`val` -> itrP.right ?: itrP

                else -> itrP
            }

            itrQ = when {

                itrQ.`val` > q.`val` -> itrQ.left ?: itrQ

                itrQ.`val` < q.`val` -> itrQ.right ?: itrQ

                else ->  itrQ
            }
        }

        return common
    }


    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}