package leetcode.sep2021;

import java.util.Arrays;

public class LC1005MaximizeSum {
    public int largestSumAfterKNegations(int[] nums, int k) {

        int negNuCnt = 0;
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < 0) {
                negNuCnt++;
            }
            result += Math.abs(num);
            min = Math.min(min, Math.abs(num));
        }
        if (negNuCnt <= k) {
            k -= negNuCnt;
            if (k % 2 == 0) {
                return result;
            }
            return result - (2 * min);
        }
        Arrays.sort(nums);
        int tmpSum = 0;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            }
            tmpSum += Math.abs(nums[i]);
        }
        return result - (2 * tmpSum);
    }

}
