package leetcode.oct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairs {

    public int findPairs(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int dupNum = 0;

        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int num : nums) {
            if (numsMap.containsKey(num)) {
                numsMap.put(num, numsMap.get(num) + 1);
            } else {
                numsMap.put(num, 1);
            }

        }

        int count = 0;
        if (k == 0) {
            for (int num : numsMap.values()) {
                if (num > 1) {
                    count++;
                }
            }
            return count;
        }

        for (int num : numsMap.keySet()) {
            if (numsMap.containsKey(num + k)) {
                count++;
            }
        }
        return count;

    }

    public int findPairsBin(int[] nums, int k) {

        Arrays.sort(nums);
        int left = 0, right = 1;
        int ans = 0;

        while (left < nums.length && right < nums.length) {
            if (left == right || nums[right] - nums[left] < k)
                right++;

            else if (nums[right] - nums[left] > k)
                left++;
            else {
                left++;
                ans++;
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
            }

        }
        return ans;
    }



    public static void main(String[] args) {
        KDiffPairs obj = new KDiffPairs();
        // int[] nums = { 3, 1, 4, 1, 5 };
        // int k = 2;

        int[] nums = { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3 };
        int k = 3;

        // int[] nums = { 1, 1, 1 ,2,2};
        // int k = 0;
        System.out.println(obj.findPairs(nums, k));
    }

}
