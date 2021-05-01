package leetcode.array;

public class LC1800MaximumSubArray {

    public int maxAscendingSum(int[] nums) {
        int result = nums[0];
        int tmpSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                tmpSum = tmpSum + nums[i];
            } else {
                result = Math.max(tmpSum, result);
                tmpSum = nums[i];
            }
        }
        return Math.max(result, tmpSum);
    }
}
