package leetcode.array;

import java.util.Arrays;

public class LC561ArrayPairSum {

    public int arrayPairSum(int[] nums) {

        int res = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i = i + 2) {
            res += Math.min(nums[i], nums[i + 1]);
        }

        return res;

    }

    public int arrayPairSumSol(int[] nums) {
        int[] exist = new int[20001];

        for (int i = 0; i < nums.length; i++)
            exist[nums[i] + 10000]++;

        int sum = 0;
        boolean odd = true;

        for (int i = 0; i < exist.length; i++) {
            while (exist[i] > 0) {
                if (odd)
                    sum += i - 10000;

                odd = !odd;
                exist[i]--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        LC561ArrayPairSum obj = new LC561ArrayPairSum();
        // int[] nums = {1,4,3,2};
        int[] nums = { 6, 2, 6, 5, 1, 2 };
        System.out.println(obj.arrayPairSum(nums));

    }

}
