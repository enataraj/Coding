package recursion;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC110BalancedTree {

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfsHelpher(root);
        return result;

    }

    private int dfsHelpher(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = dfsHelpher(node.left);
        int rightHeight = dfsHelpher(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced_Parin(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        return Math.abs(rightHeight - leftHeight) <= 1 ? 1 + Math.max(leftHeight, rightHeight) : -1;

    }

    public static void main(String[] args) {
        LC110BalancedTree obj = new LC110BalancedTree();
        TreeNode root = TreeUtil.constructBalancedBinaryTree();
        System.out.println(obj.isBalanced(root));

    }

}
