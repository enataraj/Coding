package leetcode.array;

import java.util.Arrays;

public class LC1313DecompressRLE {

    public int[] decompressRLElist(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int freq = 0;
        for (int i = 0; i < nums.length; i += 2) {
            freq += nums[i];

        }
        int[] result = new int[freq];
        int idx = 0;

        for (int i = 0; i < nums.length - 1; i = i + 2) {
            int tmpFreq = nums[i];
            int val = nums[i + 1];

            for (int j = 0; j < tmpFreq; j++) {
                result[idx] = val;
                idx++;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        LC1313DecompressRLE obj = new LC1313DecompressRLE();
        int nums[] = { 1, 1, 2, 3 };
        System.out.println(Arrays.toString(obj.decompressRLElist(nums)));
    }

}
