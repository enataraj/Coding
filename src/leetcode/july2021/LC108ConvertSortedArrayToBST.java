package leetcode.july2021;

import tree.util.TreeNode;

public class LC108ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfsHelper(nums, 0, nums.length - 1);
    }

    private TreeNode dfsHelper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfsHelper(nums, start, mid - 1);
        root.right = dfsHelper(nums, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBSTAlt(int[] nums) {
        TreeNode root = makeTree(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode makeTree(int[] nums, int start, int end) {
        if (end < start)
            return null;

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeTree(nums, start, mid - 1);
        node.right = makeTree(nums, mid + 1, end);

        return node;

    }

}
