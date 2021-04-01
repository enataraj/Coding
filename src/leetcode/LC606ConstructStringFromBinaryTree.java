package leetcode;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC606ConstructStringFromBinaryTree {

    public String tree2str(TreeNode t) {
        if (t == null)
            return "";

        if (t.left == null && t.right == null)
            return t.val + "";
        if (t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }

    
    StringBuffer strBuffer = new StringBuffer();

    private void dfsHelpher(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.right == null) {
            strBuffer.append("(");
            dfsHelpher(node.left);
            strBuffer.append(")");
        }
        if (node.left == null && node.right != null) {
            strBuffer.append("()");
            strBuffer.append("(");
            dfsHelpher(node.right);
            strBuffer.append(")");
            strBuffer.append("(");
            dfsHelpher(node.left);
            dfsHelpher(node.right);
            strBuffer.append(")");

        }

        if (node.left != null && node.right != null) {

        }

        strBuffer.append(node.val + "(");
        dfsHelpher(node.left);
        strBuffer.append(")");
        dfsHelpher(node.right);
        strBuffer.append(")");
    }

    public static void main(String[] args) {
        LC606ConstructStringFromBinaryTree obj = new LC606ConstructStringFromBinaryTree();
        TreeNode root = TreeUtil.constructBtreeString();
        System.out.println(obj.tree2str(root));

    }

}
