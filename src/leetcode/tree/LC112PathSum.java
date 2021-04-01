package leetcode.tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC112PathSum {

    boolean result = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfsHelpher(root, targetSum, 0);
        return result;

    }

    private void dfsHelpher(TreeNode node, int targetSum, int sum) {
        if (node == null) {
            return;
        }

        sum = sum + node.val;
        dfsHelpher(node.left, targetSum, sum);
        dfsHelpher(node.right, targetSum, sum);
        if (node.left == null && node.right == null && sum == targetSum) {
            result = true;
        }

    }

    private void dfsHelpherNW(TreeNode node, int targetSum, int sum) {
        if (node == null) {
            if (sum == targetSum) {
                result = true;
            }
            return;
        }
        if (result)
            return;

        sum = sum + node.val;
        dfsHelpher(node.left, targetSum, sum);
        dfsHelpher(node.right, targetSum, sum);

    }

    public boolean hasPathSumSol(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        LC112PathSum obj = new LC112PathSum();
        TreeNode root = TreeUtil.constructBinaryTreeForPathSum();
        System.out.println(obj.hasPathSum(root, 22));
    }

}
