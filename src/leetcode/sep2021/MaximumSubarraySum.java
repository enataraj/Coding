package leetcode.sep2021;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarraySum {
    
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0, max = 0;
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            if (sum == k)
                max = index + 1;
            else if (map.containsKey(sum - k))
                max = Math.max(max, index - map.get(sum - k));
            map.putIfAbsent(sum, index);
        }
        return max;
    }


}
