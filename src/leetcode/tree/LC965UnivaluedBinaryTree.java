package leetcode.tree;

import tree.util.TreeNode;

public class LC965UnivaluedBinaryTree {
    boolean result = true;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        dfsHelpher(root, root.val);
        return result;
    }

    private void dfsHelpher(TreeNode node, int val) {
        if (!result) {
            return;
        }

        if (node == null)
            return;

        if (node.val != val) {
            result = false;
        }

        dfsHelpher(node.left, val);
        dfsHelpher(node.right, val);

    }

    public static void main(String[] args) {
        LC965UnivaluedBinaryTree obj = new LC965UnivaluedBinaryTree();
    }

}
