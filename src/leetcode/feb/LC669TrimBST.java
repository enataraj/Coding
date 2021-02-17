package leetcode.feb;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC669TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        return dfsHelpher(root, low, high);

    }

    private TreeNode dfsHelpher(TreeNode node, int low, int high) {
        if (node == null) {
            return null;
        }

        if (node.val > high) {
            return trimBST(node.left, low, high);

        } else if (node.val < low) {
            return trimBST(node.right, low, high);

        }

        node.left = trimBST(node.left, low, high);
        node.right = trimBST(node.right, low, high);

        return node;

    }

    public TreeNode trimBSTSol(TreeNode root, int low, int high) {
        if (root != null) {
            while (root.left != null && root.left.val < low) {
                root.left = root.left.right;
            }
            root.left = trimBST(root.left, low, high);
            while (root.right != null && root.right.val > high) {
                root.right = root.right.left;
            }
            root.right = trimBST(root.right, low, high);
            if (root.val < low) {
                return root.right;
            } else if (root.val > high) {
                return root.left;
            } else {
                return root;
            }
        }
        return root;
    }

    private TreeNode dfsHelpherPostOrder(TreeNode node, int low, int high) {
        if (node == null) {
            return null;
        }

        node.left = dfsHelpherPostOrder(node.left, low, high);
        node.right = dfsHelpherPostOrder(node.right, low, high);
        if (node.val < low) {
            return node.right;
        } else if (node.val > high) {
            return node.left;
        }
        return node;
    }

    
    public TreeNode trimBSTPreOrderSol(TreeNode node, int low, int high) {
        if (node == null) {
               return null;
           }
           node.left = trimBST(node.left, low, high);
           node.right = trimBST(node.right, low, high);
           if (node.val < low) {
               return node.right;
           } else if (node.val > high) {
               return node.left;
           }
           return node;
        }
    
    public static void main(String[] args) {
        LC669TrimBST obj = new LC669TrimBST();
        TreeNode root = TreeUtil.constructBalancedBinaryTreeTrim();
        TreeUtil.printBinaryTreeInorder(root);
        System.out.println();
        root = obj.trimBST(root, 6, 13);
        TreeUtil.printBinaryTreeInorder(root);

    }

}
