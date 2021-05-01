package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC496NextGreaterNumber {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        Arrays.fill(result, -1);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = map.get(nums1[i]); j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    result[i] = nums2[j];
                    break;
                }
            }

        }
        return result;
    }

}
