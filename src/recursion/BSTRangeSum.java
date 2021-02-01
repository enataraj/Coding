package recursion;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class BSTRangeSum {
    private int result = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfsHelpher(root, low, high);
        return result;

    }

    private void dfsHelpher_treeTraversal(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        dfsHelpher(node.left, low, high);
        if (node.val >= low && node.val <= high) {
            result += node.val;
        }
        dfsHelpher(node.right, low, high);
    }

    private void dfsHelpher(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }

        if (node.val >= low && node.val <= high) {
            result += node.val;
            dfsHelpher(node.left, low, high);
            dfsHelpher(node.right, low, high);
        }
        if (node.val < low) {
            dfsHelpher(node.right, low, high);
        } else if (node.val > high) {
            dfsHelpher(node.left, low, high);
        }

    }

    public static void main(String[] args) {
        BSTRangeSum obj = new BSTRangeSum();
        TreeNode root = TreeUtil.constructBinarySearchTreeForRangeSum();
        System.out.println(obj.rangeSumBST(root, 6, 10));

    }

}
