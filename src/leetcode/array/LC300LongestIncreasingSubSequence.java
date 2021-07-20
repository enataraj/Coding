package leetcode.array;

import java.util.Arrays;

public class LC300LongestIncreasingSubSequence {

    // N^2 Approach
    public int lengthOfLIS(int[] nums) {
        int lis[] = new int[nums.length];

        lis[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, lis[j]);
                }
            }
            lis[i] = 1 + maxval;
        }

        int result = Integer.MIN_VALUE;
        for (int num : lis) {
            result = Math.max(num, result);
        }
        return result;
    }

    public int lengthOfLISModified(int[] nums) {
        int lis[] = new int[nums.length];
        lis[0] = 1;
        int maxAns = 1;
        for (int i = 0; i < nums.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, lis[j]);
                }
            }
            lis[i] = 1 + maxval;
            maxAns = Math.max(maxAns, lis[i]);
        }

        return maxAns;
    }

    // Bindary Search Solution nLogN
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
        LC300LongestIncreasingSubSequence obj = new LC300LongestIncreasingSubSequence();
        int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        obj.lengthOfLIS(nums);

    }

}
