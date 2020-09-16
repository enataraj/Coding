package leetcode.sep;

public class HouseRobber {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 1) {
            return Math.max(nums[0], nums[1]);
        }

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

        }

        return dp[nums.length - 1];

    }
    
    public int robopt(int[] nums) {
        int prevToPrev = 0, prev = 0, maxSoFar = 0;
        for (int n : nums) {
            maxSoFar = Math.max(prev, prevToPrev + n);
            prevToPrev = prev;
            prev = maxSoFar;
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(obj.rob(nums));

    }

}
