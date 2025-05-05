package topinterview150.medium.flattenbttolinkedlist;

import utils.TreeNode;

import java.util.*;

public class Solution {

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> toVisitStack = new Stack<>();
        toVisitStack.push(root);

        List<TreeNode> preorderList = new ArrayList<>();
        Set<TreeNode> seen = new HashSet<>();

        while(!toVisitStack.isEmpty()) {
            TreeNode node = toVisitStack.peek();
            if(!seen.contains(node)) {
                seen.add(node);
                preorderList.add(node);
                if(node.left != null) {
                    toVisitStack.push(node.left);
                } else if(node.right != null) {
                    toVisitStack.push(node.right);
                    toVisitStack.pop();
                } else {
                    toVisitStack.pop();
                }
            } else {
                toVisitStack.pop();
                if(node.right != null) {
                    toVisitStack.push(node.right);
                }
            }
        }

        TreeNode dummy = new TreeNode();

        TreeNode prev = dummy;
        for(TreeNode node : preorderList) {
            prev.left = null;
            prev.right = node;
            prev = node;
        }

        root = dummy.right;
    }

    public static void main(String[] args) {
        new Solution().flatten(TreeNode.buildTreeFromList(Arrays.asList(1,2,5,3,4,null,6)));
    }
}
