package leetcode.weekly.week247;

import java.util.Arrays;

public class MaxmizeProductDiff {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        return ((nums[len - 1] * nums[len]) - (nums[0] * nums[1]));

    }

}
