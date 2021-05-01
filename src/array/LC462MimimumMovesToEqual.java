package array;

import java.util.Arrays;

public class LC462MimimumMovesToEqual {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int a = nums[nums.length / 2];
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            c = c + Math.abs(nums[i] - a);
        }
        return c;
    }

    public int minMoves2Sol(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        int res = 0;

        while (i < j) {
            res += nums[j] - nums[i];
            i++;
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        LC462MimimumMovesToEqual obj = new LC462MimimumMovesToEqual();
        int nums[] = { 1, 2, 3 };
        System.out.println(obj.minMoves2(nums));
    }

}
