package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        int res[] = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (tmp != nums[i] && idxMap.containsKey(tmp)) {
                res[0] = idxMap.get(tmp);
                res[1] = i;
            } else {
                idxMap.put(nums[i], i);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
    }

}
