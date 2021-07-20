package leetcode.dfs;

import tree.util.TreeNode;

public class LC606ConstructStringFromBinaryTree {

    StringBuffer result = new StringBuffer();

    public String tree2str(TreeNode t) {
        if (t == null) {
            return result.toString();
        }
        dfsHelper(t);
        return result.toString();

    }

    private void dfsHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.append(node.val);
            return;
        }
        if (node.right == null) {
            result.append(node.val + "(");
            dfsHelper(node.left);
            result.append(")");
            return;
        }
        result.append(node.val);
        result.append("(");
        dfsHelper(node.left);
        result.append(")");
        result.append("(");
        dfsHelper(node.right);
        result.append(")");
    }

    
    
    class Solution {
        public String tree2str(TreeNode t) {
            if (t == null)
                return "";
            if (t.left == null && t.right == null)
                return t.val + "";
            if (t.right == null)
                return t.val + "(" + tree2str(t.left) + ")";
            return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
        }
    }

}
