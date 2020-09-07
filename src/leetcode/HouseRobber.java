package leetcode;

public class HouseRobber {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);
        }
        
        return res[nums.length-1];

    }

    public static void main(String[] args) {

        HouseRobber obj = new HouseRobber();
       // int[] nums = { 1, 2, 3, 1 };
        int[] nums  = {2,7,9,3,1};

        System.out.println(obj.rob(nums));

    }

}
