package leetcode.aug2021;

import tree.util.TreeNode;

public class LC1448CountGoodNode {

    int result = 0;

    public int goodNodes(TreeNode root) {
        dfsHelper(root, root.val);
        return result;

    }

    private void dfsHelper(TreeNode node, int maxValue) {
        if (node == null) {
            return;
        }
        if (node.val >= maxValue) {
            maxValue = node.val;
            result++;
        }

        dfsHelper(node.left, maxValue);
        dfsHelper(node.right, maxValue);

    }

}
