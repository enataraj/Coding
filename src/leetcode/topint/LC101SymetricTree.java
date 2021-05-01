package leetcode.topint;

import tree.util.TreeNode;

public class LC101SymetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfsHelpher(root.left, root.right);

    }

    private boolean dfsHelpher(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && dfsHelpher(left.left, right.right) && dfsHelpher(left.right, right.left);
    }

}
