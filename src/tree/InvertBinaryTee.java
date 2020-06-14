package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class InvertBinaryTee {
    
    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBinaryTree();
        TreeUtil.printBinaryTreeInorder(root);
        System.out.println();
        root = invertBinaryTree(root);
        TreeUtil.printBinaryTreeInorder(root);
    }
    
    
    public static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

}
