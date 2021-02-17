package leetcode;

public class LC674LongestIncreasingSubArray {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int longestSubarrayLength = 1;
        int tmpLeng = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                tmpLeng++;
            } else {
                longestSubarrayLength = Math.max(tmpLeng, longestSubarrayLength);
                tmpLeng = 1;
            }
        }

        return longestSubarrayLength;

    }

    public static void main(String[] args) {
        LC674LongestIncreasingSubArray obj = new LC674LongestIncreasingSubArray();
        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(obj.findLengthOfLCIS(nums));
    }

}
