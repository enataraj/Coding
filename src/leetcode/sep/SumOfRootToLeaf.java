package leetcode.sep;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class SumOfRootToLeaf {

    int sum = 0;

    public int sumRootToLeafSol(TreeNode root) {
        return sumBinary(root, 0);
    }

    private int sumBinary(TreeNode root, int prev) {
        if (root == null)
            return 0;
        int next = prev * 2 + root.val;
        if (root.right == null && root.left == null)
            return next;
        return sumBinary(root.left, next) + sumBinary(root.right, next);
    }

    public int sumRootToLeaf(TreeNode root) {
        dfsHelper(root, "");
        return 0;
    }

    private void dfsHelper(TreeNode root, String str) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            str += String.valueOf(root.val);
            int val = Integer.parseInt(str, 2);
            sum += val;
            return;
        }

        str += String.valueOf(root.val);
        dfsHelper(root.left, str);
        dfsHelper(root.right, str);
    }

    public static void main(String[] args) {
        SumOfRootToLeaf obj = new SumOfRootToLeaf();
        System.out.println(obj.sumRootToLeaf(TreeUtil.constructBinaryTreeBinary()));
    }

}
