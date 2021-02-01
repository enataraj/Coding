package recursion;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC104MaxDepthOfBinaryTree {

    int res = 0;

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        dfsHelpher(root, 0);
        return res;
    }

    private void dfsHelpher(TreeNode node, int count) {
        if (node == null) {
            res = Math.max(count, res);
            count = 0;
            return;
        }

        dfsHelpher(node.left, count + 1);
        dfsHelpher(node.right, count + 1);
    }

    public int maxDepthParin(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth_Sol(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        LC104MaxDepthOfBinaryTree obj = new LC104MaxDepthOfBinaryTree();
        TreeNode root = TreeUtil.constructDepthTree();
        System.out.println(obj.maxDepth(root));

    }

}
