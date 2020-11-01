package leetcode.oct;


public class HouseRobber2 {
    
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    int rob(int[] nums, int l, int r) {
        int preRob = nums[l];
        int preNotRob = 0;
        for (int i = l + 1; i <= r; i++) {
            int curRob = preNotRob + nums[i];
            preNotRob = Math.max(preRob, preNotRob);
            preRob = curRob;
        }
        
        return Math.max(preRob, preNotRob);
    }
    
    public int robrec(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        return Math.max(helper(nums, 0, n-2), 
                        helper(nums, 1, n-1));
    }
    
    private int helper(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        
        int max = 0;
        for (int i = start; i <= end; i++) {
            dp[i] = (i-3) >= start
                    ? Math.max(dp[i-3], dp[i-2]) + nums[i]
                    : (i-2) >= start
                        ? dp[i-2] + nums[i]
                        : nums[i];
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    

    public int robFixME(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }

        int res[] = new int[nums.length - 1];
        res[0] = nums[0];
        res[1] = Math.max(res[0], nums[1]);

        for (int i = 2; i < nums.length - 1; i++) {
            res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);

        }

        int res1[] = new int[nums.length ];
        res1[1] = nums[1];
        res1[2] = Math.max(nums[1], nums[2]);

        for (int i = 3; i < nums.length ; i++) {
            res1[i - 1] = Math.max(res1[i - 2] + nums[i], res1[i - 1]);

        }

        return Math.max(res[nums.length - 2], res1[nums.length - 1]);
    }

    public static void main(String[] args) {

        HouseRobber2 obj = new HouseRobber2();
        int[] nums = { 1, 2, 1, 1 };
        System.out.println(obj.rob(nums));
    }

}
