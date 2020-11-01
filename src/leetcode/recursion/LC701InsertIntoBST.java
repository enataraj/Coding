package leetcode.recursion;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC701InsertIntoBST {
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
    public static void main(String[] args) {
        
        LC701InsertIntoBST obj = new LC701InsertIntoBST();
        
        TreeNode root = TreeUtil.constructBinarySearchTree1();
        TreeUtil.inOrderTraversal(root);
        obj.insertIntoBST(root, 8);
        System.out.println();
        TreeUtil.inOrderTraversal(root);
        
        
    }

}
