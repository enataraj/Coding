package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1)
            return nums[0];

        Map<Integer, Integer> freMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (freMap.containsKey(nums[i])) {
                int count = freMap.get(nums[i]) + 1;
                if (count > nums.length / 2) {
                    return nums[i];

                }
                freMap.put(nums[i], count);

            } else {
                freMap.put(nums[i], 1);
            }

        }
        return -1;

    }

    public int majorityElementOpt(int[] nums) {
        int count = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (result != nums[i]) {
                count--;
                if (count == 0) {
                    result = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(obj.majorityElement(nums));
    }

}
