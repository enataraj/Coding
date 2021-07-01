package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

import tree.util.TreeNode;

public class LC530MinAbsoDiff {

    int result = Integer.MAX_VALUE;
    TreeNode prevRoot = null;

    public int getMinimumDifference(TreeNode root) {
        dfsHelper(root);
        return result;
    }

    private void dfsHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        dfsHelper(node.left);
        if (prevRoot != null) {
            result = Math.min(result, Math.abs(prevRoot.val - node.val));
        }
        prevRoot = node;
        dfsHelper(node.right);
    }

    public int getMinimumDifference_2n(TreeNode root) {
        int result = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        dfsHelper(root, list);
        for (int i = 1; i < list.size(); i++) {
            result = Math.min(result, Math.abs(list.get(i - 1) - list.get(i)));
        }

        return result;

    }

    private void dfsHelper(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        dfsHelper(node.left, values);
        values.add(node.val);
        dfsHelper(node.right, values);
    }

}
