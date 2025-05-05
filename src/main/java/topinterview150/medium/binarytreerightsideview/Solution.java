package topinterview150.medium.binarytreerightsideview;

import utils.TreeNode;

import java.util.*;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }

        List<Integer> ans = new ArrayList<>();
        Queue<BfsNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(new BfsNode(root, 0));
        Set<Integer> seen = new HashSet<>();

        while(!bfsQueue.isEmpty()) {
            BfsNode bfsNode = bfsQueue.remove();
            if(!seen.contains(bfsNode.level)) {
                ans.add(bfsNode.node.val);
                seen.add(bfsNode.level);
            }
            if(bfsNode.node.right != null) {
                bfsQueue.add(new BfsNode(bfsNode.node.right, bfsNode.level + 1));
            }
            if(bfsNode.node.left != null) {
                bfsQueue.add(new BfsNode(bfsNode.node.left, bfsNode.level + 1));
            }
        }

        return ans;
    }

    private static class BfsNode {
        private final TreeNode node;
        private final int level;

        public BfsNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        public TreeNode getNode() {
            return node;
        }

        public int getLevel() {
            return level;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTreeFromList(Arrays.asList(1, 2, 3, null, 5, null, 4));
        List<Integer> integers = new Solution().rightSideView(treeNode);
    }
}
