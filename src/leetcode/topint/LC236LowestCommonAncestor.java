package leetcode.topint;

import tree.util.TreeNode;

public class LC236LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfsHelper(root, p, q);
    }

    private TreeNode dfsHelper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return node;
        }
        if (node == p || node == q) {
            return node;

         }

        TreeNode left = dfsHelper(node.left, p, q);
        TreeNode right = dfsHelper(node.right, p, q);

        if ((left == p || left == q) && (left == q || right == q)) {
            return node;

        }

       
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }

        return null;

    }

    public TreeNode lowestCommonAncestorSol(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }

}
