package leetcode.oct;

import java.util.Arrays;

public class LongestIncresingSubsequence {
    
    
    
    
    
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length,
            longestLength = 0;
        int[] longest = new int[n],
            counts = new int[n];
        
        Arrays.fill(longest, 1);
        Arrays.fill(counts, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (longest[i] < longest[j] + 1) {
                        longest[i] = longest[j] + 1;
                        counts[i] = counts[j];
                        
                    } else if (longest[i] == longest[j] + 1) {
                        counts[i] += counts[j];
                    }
                }
            }
            
            longestLength = Math.max(longestLength, longest[i]);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (longest[i] == longestLength) {
                ans += counts[i];
            }
        }
        
        return ans;
    }
    

    

    public static void main(String[] args) {
        LongestIncresingSubsequence obj = new LongestIncresingSubsequence();
      //  int[] nums = { 1, 2, 4, 3, 5, 4, 7, 8, 17, 9, 19 };
        int[] nums = { 1,3,5,4,7};
        System.out.println(obj.findNumberOfLIS(nums));
    }

}
