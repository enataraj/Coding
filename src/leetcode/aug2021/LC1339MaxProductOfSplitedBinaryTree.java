package leetcode.aug2021;

import tree.util.TreeNode;

public class LC1339MaxProductOfSplitedBinaryTree {
    int totalSum = 0;
    long result = Long.MIN_VALUE;
    int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        findTotalSum(root);
        findMaxProduct(root);
        return (int) (result % MOD);
    }

    private void findTotalSum(TreeNode node) {
        if (node == null) {
            return;
        }
        totalSum += node.val;
        findTotalSum(node.left);
        findTotalSum(node.right);
    }

    private int findMaxProduct(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + findMaxProduct(node.left) + findMaxProduct(node.right);
        result = Math.max(result, (totalSum - sum * sum));
        return sum;
    }

}
