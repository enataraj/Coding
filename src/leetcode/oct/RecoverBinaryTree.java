package leetcode.oct;

import java.util.Stack;

import tree.util.TreeNode;

public class RecoverBinaryTree {
    
    
    // Approach 1
    
    public void recoverTree(TreeNode root) {
        TreeNode node1 = null, // null
            node2 = null; // null
        
        Stack<TreeNode> stack = new Stack<>(); // 
        TreeNode cur = root, // 1
            prev = null; // null
        
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
                
            } else {
                cur = stack.pop();
                if (prev != null && prev.val > cur.val) {
                    if (node1 == null) {
                        node1 = prev;
                    }
                    
                    if (cur.val < node1.val) {
                        node2 = cur;
                    }
                    
                }
                
                prev = cur;
                cur = cur.right;
            }
        }
        
        // swap node1 and node2
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
        
    }
    
    
    
    
    // Approach 2
    
    
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;
    public void recoverTreeBest(TreeNode root) {
        travers(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void travers(TreeNode node){
        if(node == null) return;
        travers(node.left);
        if(first == null && pre != null && pre.val >= node.val){
            first = pre;
        }
        if(first != null &&pre != null && pre.val >= node.val){
            second = node;
        }
        
        pre = node;
        travers(node.right);
    }
    
   
    
    
    // Approach 3
    
    TreeNode mismatch1 = null;
    TreeNode mismatch2 = null;
    
    boolean found1 = false;
    boolean found2 = false;
    
    public void recoverTreeAlt(TreeNode root) {
        if(root == null) return;
        
        inOrderTraversalForward(root);
        inOrderTraversalBackward(root);

        int temp = mismatch1.val;
        mismatch1.val = mismatch2.val;
        mismatch2.val = temp;
    }
    
    public void inOrderTraversalForward(TreeNode root) {
        if(root == null) return;
        
        inOrderTraversalForward(root.left);
        
        if(mismatch1 != null && root.val < mismatch1.val){
            found1 = true;  
            return;
        }
        
        if(!found1)
            mismatch1 = root;
        
        inOrderTraversalForward(root.right);
    }
    
    public void inOrderTraversalBackward(TreeNode root) {
        if(root == null) return;
        
        inOrderTraversalBackward(root.right);
        
        if(mismatch2 != null && root.val > mismatch2.val){
            found2 = true;  
            return;
        }
        
        if(!found2)
            mismatch2 = root;
        
        inOrderTraversalBackward(root.left);
    }

}
