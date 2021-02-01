package leetcode.jan;

import java.util.Arrays;

public class LC1679MaxNumberOfKPairs {

    public int maxOperations(int[] nums, int k) {
        int cnt = 0;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                cnt++;
                i++;
                j--;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return cnt;

    }

    public static void main(String[] args) {
        LC1679MaxNumberOfKPairs obj = new LC1679MaxNumberOfKPairs();
        int[] nums = { 3, 1, 3, 4, 3 };
        int k = 6;
        System.out.println(obj.maxOperations(nums, k));

    }

}
