package leetcode.dec;

import java.util.Arrays;

public class LC977quaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];

        int i = 0;
        int j = len - 1;
        int idx = len - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[idx] = nums[i]*nums[i];
                i++;

            } else {
                res[idx] = nums[j]*nums[j];
                j--;
            }
            idx--;

        }

        return res;
    }

    public static void main(String[] args) {
        LC977quaresOfSortedArray obj = new LC977quaresOfSortedArray();
        // int nums[] = { -4, -1, 0, 3, 10 };
        // int nums[] = { -5, -4, -3, -2 };
        // int nums[] = { -10000, -9999, -7, -5, 0,0, 1, 10000 };
        int nums[] = { -3, 0, 2 };
        nums = obj.sortedSquares(nums);
        System.out.println(Arrays.toString(nums));

    }

}
