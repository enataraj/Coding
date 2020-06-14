package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int maxSubsetSize = 1, maxIdx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxSubsetSize) {
                        maxSubsetSize = dp[i];
                        maxIdx = i;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        List<Integer> res = new ArrayList<>();
        res.add(nums[maxIdx]);
        int subsetSize = maxSubsetSize - 1; // next subset size to look for in DP array

        for (int i = maxIdx - 1; i >= 0; i--) {
            if (nums[maxIdx] % nums[i] == 0 && dp[i] == subsetSize) {
                res.add(nums[i]);
                --subsetSize;
            }
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 6, 9, 10 };
        List<Integer> res = new LargestDivisibleSubset().largestDivisibleSubset(nums);
        System.out.println(res);
    }

}
