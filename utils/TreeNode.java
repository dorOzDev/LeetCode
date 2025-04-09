package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTreeFromList(List<Integer> list) {
        if (list == null || list.isEmpty() || list.getFirst() == null) {
            return null;
        }

        TreeNode root = new TreeNode(list.getFirst());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (index < list.size()) {
            TreeNode current = queue.poll();

            // Left child
            if (index < list.size() && list.get(index) != null) {
                current.left = new TreeNode(list.get(index));
                queue.offer(current.left);
            }
            index++;

            // Right child
            if (index < list.size() && list.get(index) != null) {
                current.right = new TreeNode(list.get(index));
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    public static void printTreeLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(current.val));
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        // Trim trailing nulls for cleaner output
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }

        System.out.println(result);
    }

}