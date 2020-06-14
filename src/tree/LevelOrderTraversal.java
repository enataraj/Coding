package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LevelOrderTraversal {

    /*
     * 
     * TreeNode root = new TreeNode(10); root.left = new TreeNode(8); root.right =
     * new TreeNode(16); root.left.left = new TreeNode(6); root.left.right = new
     * TreeNode(9); root.right.left = new TreeNode(12); root.right.right = new
     * TreeNode(20);
     * 
     */

    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBinaryTree();
        TreeUtil.preOrderTraversal(root);
        System.out.println();
        TreeUtil.postOrderTraversal(root);
        System.out.println();
        int height = heightOfBinaryTree(root);
        System.out.println("Height of Binary tree " + height);
        System.out.println();
        for (int i = 1; i <= height; i++) {
            levelOrderTraversal(root, i);
        }

    }

    private static int heightOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lHeight = heightOfBinaryTree(root.left);
        int rHeight = heightOfBinaryTree(root.right);

        return Math.max(lHeight, rHeight) + 1;

    }

    private static void levelOrderTraversal(TreeNode root, int height) {
        if (root == null) {
            return;

        }
        if (height == 1) {
            System.out.print(" " + root.val);
        } else if (height > 1) {

            levelOrderTraversal(root.left, height - 1);
            levelOrderTraversal(root.right, height - 1);
        }
    }

}
