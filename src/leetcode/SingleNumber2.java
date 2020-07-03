package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {

    public int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result = -1;

        return result;

    }

    // Time : O(n)
    // Space : O(n)
    public int singleNumberWithFreMap(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> freMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freMap.get(nums[i]) != null) {
                freMap.put(nums[i], freMap.get(nums[i]) + 1);
            } else {
                freMap.put(nums[i], 1);
            }
        }

        for (int key : freMap.keySet()) {
            if (freMap.get(key) % 3 != 0) {
                return key;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int nums[] = { 6, 6, 6, 7, 34, 7, 7, 8, 8, 8 };
        SingleNumber2 obj = new SingleNumber2();
        int result = obj.singleNumber(nums);
        System.out.println("Result : " + result);

    }

}
