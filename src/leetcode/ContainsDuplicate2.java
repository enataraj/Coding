package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int oldIdx = map.get(nums[i]);
                if (Math.abs(oldIdx - i) <= k) {
                    return true;
                }
                map.put(nums[i], i);

            } else {
                map.put(nums[i], i);
            }

        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate2 obj = new ContainsDuplicate2();
        int k = 2;
        int[] nums = { 1, 2, 3, 1, 2, 3 };
        System.out.println(obj.containsNearbyDuplicate(nums, k));
    }
}
