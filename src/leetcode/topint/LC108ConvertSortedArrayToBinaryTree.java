package leetcode.topint;

import tree.util.TreeNode;

public class LC108ConvertSortedArrayToBinaryTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        return dfsHelpher(nums, 0, nums.length - 1);

    }

    private TreeNode dfsHelpher(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfsHelpher(nums, left, mid-1);
        node.right = dfsHelpher(nums, mid + 1, right);
        return node;

    }
}
