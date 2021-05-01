package leetcode.array;

import java.util.Arrays;

public class LC238ProductOfArrayExceptSelf {

    public int[] productExceptSelfSol(int[] nums) {
        int[] out = new int[nums.length];

        int prev = 1;
        for (int i = 0; i < nums.length; i++) {
            out[i] = prev;
            prev *= nums[i];
        }

        prev = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            out[i] *= prev;
            prev *= nums[i];
        }

        return out;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        Arrays.fill(leftProduct, 1);
        Arrays.fill(rightProduct, 1);
        int[] res = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];

        }

        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = leftProduct[i] * rightProduct[i];
        }
        return res;
    }

}
