package leetcode.april;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.TreeNode;

public class LC1302DeepestLeavesSum {

    public int deepestLeavesSumBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return sum;

    }

    int deepestLevel = 0;

    void helper(TreeNode root, int crrLevel) {
        if (root == null) {
            return;
        }
        if (crrLevel >= deepestLevel) {
            sum = crrLevel == deepestLevel ? sum + root.val : root.val;
            deepestLevel = crrLevel;
        }
        helper(root.left, crrLevel + 1);
        helper(root.right, crrLevel + 1);

    }

    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = heightOfTree(root);
        sumOfDeepestNode(root, height, 0);
        return sum;

    }

    private int heightOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = 1 + heightOfTree(node.left);
        int right = 1 + heightOfTree(node.right);
        return Math.max(left, right);
    }

    private void sumOfDeepestNode(TreeNode node, int height, int currentHeight) {
        if (node == null) {
            return;
        }

        if (height == currentHeight) {
            sum += node.val;
            return;
        }

        sumOfDeepestNode(node.left, height, currentHeight + 1);
        sumOfDeepestNode(node.right, height, currentHeight + 1);

    }

    public static void main(String[] args) {
        LC1302DeepestLeavesSum obj = new LC1302DeepestLeavesSum();
    }

}
