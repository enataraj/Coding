package leetcode.may;

import java.util.Arrays;

public class LC45JumpGameII {

    public int jump(int[] nums) {
        if (nums.length == 1) {

            return 0;

        }

        int jump = 0;
        int maxValue = 0;
        int maxReach = 0;
        int i = 0;
        while (i < nums.length) {
            if (maxReach == nums.length - 1) {
                break;
            }

            maxValue = Math.max(maxValue, i + nums[i]);
            if (i == maxReach) {
                maxReach = maxValue;
                jump++;
            }
            i++;

        }

        return jump;

    }

    public int jumpAlt(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int end = 0, res = 0, i = 0;
        while (i < nums.length) {
            res++;
            int tmp = 0;
            for (int j = i; j <= end; j++) {
                tmp = Math.max(tmp, j + nums[j]);
            }
            if (tmp >= nums.length - 1)
                return res;
            i = end + 1;
            end = tmp;
        }
        return res;
    }

    public int jumpDp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // We are already standing at the first array element.
        dp[0] = 0;

        // Trying different lengths one by one.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= j + nums[j] && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        LC45JumpGameII obj = new LC45JumpGameII();
        int[] nums = { 1, 1 };
        System.out.println(obj.jump(nums));

    }
}
