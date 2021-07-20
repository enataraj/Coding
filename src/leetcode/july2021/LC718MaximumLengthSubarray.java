package leetcode.july2021;

import java.util.Arrays;

public class LC718MaximumLengthSubarray {
    public int findLength(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int result = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(dp[i][j], result);
                }

            }
            
        }
        printMatrix(dp);
        return result;

    }
    
    

    private void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1,  3, 2, 1,4,7 };
        int[] nums2 = { 3, 2, 1, 4,7 };
        LC718MaximumLengthSubarray obj = new LC718MaximumLengthSubarray();
        System.out.println(obj.findLength(nums1, nums2));
    }

}
