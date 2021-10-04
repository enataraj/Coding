package leetcode.tree;

import tree.util.TreeNode;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return validBSTHelpher(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validBSTHelpher(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return (validBSTHelpher(node.left, min, node.val) && validBSTHelpher(node.right, node.val, max));
    }
    
    
    private boolean isBST(TreeNode root, long left, long right){
        if(root == null)
            return true;
        if (root.val <= left || root.val >= right) {
            return false;
        }
        boolean leftRes = isBST(root.left, left, root.val);
        boolean rightRes = isBST(root.right, root.val, right);
        if(leftRes && rightRes)
            return true;
        return false;
    }
    
    
    public boolean isValidBST_Optimized(TreeNode root) {
        if (root==null) {
            return true;
        }
        return helper(root.left, null, root.val) &&
           helper(root.right, root.val, null);
    }
    
    boolean helper(TreeNode curr, Integer min, Integer max) {
        if (curr==null) {
            return true;
        }
        
        if ((min!=null && curr.val <= min) || (max !=null && curr.val >= max)) {
            return false;
        }
        return helper(curr.left, min, curr.val) &&
            helper(curr.right, curr.val, max);
        
    }

}
