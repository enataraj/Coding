package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class HeightOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBinaryTree();
        int height = heightOfBinaryTree(root);
        System.out.println("Height of Binary tree " + height);

    }

    private static int heightOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lHeight = heightOfBinaryTree(root.left);
        int rHeight = heightOfBinaryTree(root.right);

        return Math.max(lHeight, rHeight)+1;

    }
   

}
