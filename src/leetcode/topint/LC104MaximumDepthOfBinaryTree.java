package leetcode.topint;

import tree.util.TreeNode;

public class LC104MaximumDepthOfBinaryTree {
   
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;       
    }
}
