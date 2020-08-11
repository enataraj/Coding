package leetcode.july;

import tree.util.TreeNode;

public class ConstructBinaryTree {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, postorder.length-1);
    }
    // Everytime we just need to know the root index in postorder array
    private TreeNode helper(int[] in, int lo, int hi, int[] post, int index) {
        if (lo > hi) return null;
        TreeNode root = new TreeNode(post[index]);
        // i is the count ot nodes in right sub tree
        int i = 0;
        while (in[hi - i] != post[index]) ++i;
        root.left = helper(in, lo, hi - i - 1, post, index - 1 - i);
        root.right = helper(in, hi - i + 1, hi, post, index - 1);
        return root;
    }
    
    
    
    public TreeNode buildTreeParin(int[] inorder, int[] postorder) {
        return helperParin(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode helperParin(int[] inorder, int sInorder, int eInorder, int[] postorder, int sPostorder, int ePostorder) {
        if (sInorder > eInorder || sPostorder > ePostorder) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[ePostorder]);
        
        int rootValIdx = -1;
        for (int i = sInorder; i <= eInorder; i++) {
            if (inorder[i] == root.val) {
                rootValIdx = i;
                break;
            }
        }
        
        int leftLen = rootValIdx - sInorder;
        root.left = helperParin(inorder, sInorder, rootValIdx - 1, postorder, sPostorder, sPostorder + leftLen - 1);
        root.right = helperParin(inorder, rootValIdx + 1, eInorder, postorder, sPostorder + leftLen, ePostorder - 1);
        
        return root;
    }


}
