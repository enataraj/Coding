package leetcode.sep2021;

import java.util.Arrays;

public class LC1608SpecialArray {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] >= nums.length) {
            return nums.length;
        }
        for (int x = nums.length - 1; x > 0; x--) {
            int idx = nums.length - x;
            if (nums[idx] >= x && nums[idx - 1] < x) {
                return x;
            }
        }
        return -1;
    }

    public int specialArrayAlt(int[] nums) {
        int length = nums.length;
        int[] freMap = new int[length + 1];
        for (int num : nums) {
            if (num >= length) {
                freMap[length]++;
            } else {
                freMap[num]++;
            }
        }

        int count = 0;

        for (int i = length; i > 0; i--) {
            count += freMap[i];
            if (count == i) {
                return i;
            }
        }
        return -1;
    }

}
