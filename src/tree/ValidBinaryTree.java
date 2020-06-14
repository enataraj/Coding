package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class ValidBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBinaryTree();
        boolean res = isBSTNull(root, null, null);
        if (res) {
            System.out.println("Binary Tree ... ");
        } else {
            System.out.println("Not Binary Tree ...");
        }

        res = isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        if (res) {
            System.out.println("Binary Tree ... ");
        } else {
            System.out.println("Not Binary Tree ...");
        }
    }

    // Leet Code wrong Answer ([5,1,4,null,null,3,6])
    private static boolean isBSTNull(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            return true;
        }

        if (left != null && left.val >= root.val) {
            return false;

        }

        if (right != null && right.val <= root.val) {
            return false;
        }

        return (isBSTNull(root.left, left, root) || isBSTNull(root.right, root, right));
    }

    private static boolean isBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;

        }
        return ((isBST(root.left, min, root.val) && isBST(root.right, root.val, max)));
    }

}
