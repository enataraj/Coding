package leetcode;

import java.util.Arrays;

public class RunningSum {

	public int[] runningSum(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}

		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i];
		}

		return nums;

	}

	public static void main(String[] args) {
		int[] nums = {  };
		int res[] = new RunningSum().runningSum(nums);
		System.out.println(Arrays.toString(res));

	}

}
