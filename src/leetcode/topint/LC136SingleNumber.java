package leetcode.topint;

public class LC136SingleNumber {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public int singleNumberSol(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }

}
