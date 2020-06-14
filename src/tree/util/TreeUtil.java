package tree.util;

public class TreeUtil {

    public static TreeNode constructBinaryTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(16);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);
        return root;
    }

    public static void printBinaryTreeInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printBinaryTreeInorder(root.left);
        System.out.print(" " + root.val);
        printBinaryTreeInorder(root.right);
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(" " + root.val);
        inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(" " + root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        System.out.print(" " + root.val);
        postOrderTraversal(root.right);
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
