package leetcode.easy.collection;

import java.util.Arrays;

public class RotateAnarray {

	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0 || nums.length == 1) {
			return;
		}

		k = k % nums.length;

		if (k == 0) {
			return;
		}

		// Rotate the whole array
		// Rotate the firsdt k number
		// Rotate the last n-k number
		int l = 0, r = nums.length - 1;

		rotate(nums, l, r);
		rotate(nums, l, k - 1);
		rotate(nums, k, r);

		System.out.println(Arrays.toString(nums));

	}

	private void rotate(int[] nums, int l, int r) {
		int tmp = 0;
		while (l < r) {
			tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };
		RotateAnarray obj = new RotateAnarray();
		obj.rotate(nums, 2);

	}
}
