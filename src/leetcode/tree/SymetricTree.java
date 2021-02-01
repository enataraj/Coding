package leetcode.tree;

import tree.util.TreeNode;

public class SymetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricOrNot(root.left, root.right);
    }

    public boolean isSymmetricOrNot(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return (left.val == right.val) && isSymmetricOrNot(left.right, right.left)
                && isSymmetricOrNot(left.left, right.right);
    }

    public static void main(String[] args) {
        SymetricTree obj = new SymetricTree();
    }

}
