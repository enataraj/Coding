package tree;

import tree.util.TreeNode;

public class LC543DiameterOfBinaryTree {
    
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
       
        dfsHelpher(root);
        return ans;
    }
    
    private int dfsHelpher(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = dfsHelpher(node.left);
        int right = dfsHelpher(node.right);
        ans = Math.max(ans,left+right);
        return Math.max(left,right)+1;
    }

}
