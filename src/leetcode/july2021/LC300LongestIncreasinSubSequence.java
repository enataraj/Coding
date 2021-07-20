package leetcode.july2021;

import java.util.Arrays;

public class LC300LongestIncreasinSubSequence {

    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, j);
                }
            }
            lis[i] = maxVal + 1;
            res = Math.max(lis[i], res);
        }
        return res;
    }
    
    public int lengthOfLISBinarySearch(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LC300LongestIncreasinSubSequence obj = new LC300LongestIncreasinSubSequence();
    }

}
