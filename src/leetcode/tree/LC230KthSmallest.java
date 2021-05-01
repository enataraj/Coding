package leetcode.tree;

import tree.util.TreeNode;

public class LC230KthSmallest {
    int cnt = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        dfsHelpher(root, k);
        return result;
    }

    private void dfsHelpher(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        dfsHelpher(node.left, k);
        if (++cnt == k) {
            result = node.val;
        }
        dfsHelpher(node.right, k);

    }

    public static void main(String[] args) {
        LC230KthSmallest obj = new LC230KthSmallest();

    }

}
