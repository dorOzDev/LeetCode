package topinterview150.easy.maximumdepthofbinarytree;

import utils.TreeNode;


public class Solution {

    public int maxDepth(TreeNode root) {
        return calcMaxDepthRecursivley(root, 0);
    }

    private int calcMaxDepthRecursivley(TreeNode root, int currentDepth) {
        if(root == null) {
            return currentDepth;
        }

        int leftDepth = calcMaxDepthRecursivley(root.left, currentDepth + 1);
        int rightDepth = calcMaxDepthRecursivley(root.right, currentDepth + 1);

        return Math.max(leftDepth, rightDepth);
    }
}
