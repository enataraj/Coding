package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LC1365NumberSmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            idxMap.put(nums[i], i);
        }

        int[] nums1 = nums;
        Arrays.sort(nums);

        Map<Integer, Integer> idxMap1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            idxMap1.put(nums[i], i);
        }
        
        System.out.println(idxMap);
        System.out.println(idxMap1);
        

        int result[] = new int[nums.length];
        
        for(int num:nums1) {
            
        }

        System.out.println(idxMap);
        return null;

    }

    public static void main(String[] args) {
        LC1365NumberSmallerThanCurrent obj = new LC1365NumberSmallerThanCurrent();
        int[] nums = { 8, 1, 2, 2, 3 };
        System.out.println(Arrays.toString(obj.smallerNumbersThanCurrent(nums)));

    }

}
