package leetcode.tree;

import tree.util.TreeNode;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return validBSTHelpher(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validBSTHelpher(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return (validBSTHelpher(node.left, min, node.val) && validBSTHelpher(node.right, node.val, max));
    }

}
