package leetcode.april;

import java.util.Arrays;

public class LC377CombinationSum4 {

    int[] memo;

    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        dfsHelpher(nums, target);
        return memo[target];
    }

    private int dfsHelpher(int[] nums, int target) {
        if (memo[target] > -1) {
            return memo[target];
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                result += dfsHelpher(nums, target - nums[i]);
            }
        }
        System.out.println(Arrays.toString(memo));
        memo[target] = result;
        return memo[target];
    }

    // TLE

    public int combinationSum4TLE(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }

        int result = 0;
        for (int num : nums) {
            if (target - num > 0) {
                result += combinationSum4(nums, target - num);
            }
        }
        return result;
    }

    // DP sol

    public int combinationSum4DP(int[] nums, int target) {
        memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    memo[i] += memo[i - num];
                }
            }
        }
        return memo[target];
    }

    public static void main(String[] args) {
        LC377CombinationSum4 obj = new LC377CombinationSum4();
        int[] nums = { 1, 2, 3 };
        int target = 4;
        System.out.println(obj.combinationSum4(nums, target));
        System.out.println(obj.combinationSum4TLE(nums, target));

    }

}
