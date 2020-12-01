package leetcode.nov;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class MaxDifferenceAncestor {
    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfsHelper(root);
        return result;
    }

    private int[] dfsHelper(TreeNode node) {
        if (node == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        } else if (node.left == null && node.right == null) {
            return new int[] { node.val, node.val };
        }

        int[] leftRes = dfsHelper(node.left); 
        int[] rightRes = dfsHelper(node.right); 

        int min = Math.min(leftRes[0], rightRes[0]); 
        int max = Math.max(leftRes[1], rightRes[1]); 

        result = Math.max(result, Math.max(Math.abs(node.val - min), Math.abs(node.val - max)));

        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        return new int[] { min, max };

    }
    
    
    int res = 0;
    public int maxAncestorDiff_Alter(TreeNode root) {
        if (root == null) return 0;
        
        getDiff(root, root.val, root.val);
        return res;
    }
    
    private void getDiff(TreeNode curr, int currMin, int currMax){
        if (curr == null) return;
        int currRes = Math.max(Math.abs(curr.val - currMin), Math.abs(curr.val - currMax));
        res = Math.max(currRes, res);
        currMin = Math.min(currMin, curr.val);
        currMax = Math.max(currMax, curr.val);
        getDiff(curr.left, currMin, currMax);
        getDiff(curr.right, currMin, currMax);
    }

    public static void main(String[] args) {
        MaxDifferenceAncestor obj = new MaxDifferenceAncestor();
        TreeNode root = TreeUtil.constructBinaryTreeAncestorDiff();
        System.out.println(obj.maxAncestorDiff(root));

    }

}
