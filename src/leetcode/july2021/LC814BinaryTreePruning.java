package leetcode.july2021;

import tree.util.TreeNode;

public class LC814BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;

        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;       
    }

     public boolean helper(TreeNode node,TreeNode parent,boolean isLeft){
        
        if(node==null) 
            return false;
        
        boolean isLeftHasOne =  helper(node.left,node,true);
        boolean isRightHasOne = helper(node.right,node,false);
        
        if(!isLeftHasOne && !isRightHasOne && node.val!=1 && parent!=null){
            if(isLeft){
                parent.left=null;
            }else{
                parent.right=null;
            }
        }
        
        return isLeftHasOne || isRightHasOne || node.val==1;
    }

}
