package array;

public class MaxSumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = currentSum + nums[i];

            currentSum = Math.max(currentSum, nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;

    }

    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
