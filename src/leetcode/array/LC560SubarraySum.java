package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class LC560SubarraySum {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int result = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum == k) {
                result++;
            }
            int preSum = sum - k;
            if (sumMap.containsKey(preSum)) {
                result += sumMap.get(preSum);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);

        }

        return result;
    }

    public int subarraySumSol(int[] nums, int k) {
        int out = 0;
        if (nums.length < 400) {
            for (int i = 0; i < nums.length; i++) {
                int currSum = 0;
                for (int j = i; j < nums.length; j++) {
                    currSum += nums[j];
                    if (currSum == k)
                        out++;
                }
            }
            return out;
        }

        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.merge(sum + k, 1, Integer::sum);// (old, val) -> old + val
            sum += nums[i];
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC560SubarraySum obj = new LC560SubarraySum();
        int[] nums = { -1, -1, 1 };
        int k = 0;
        System.out.println(obj.subarraySum(nums, k));
    }

}
