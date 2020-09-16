package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxDegreeShortestSubarray {

    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (idxMap.containsKey(nums[i])) {
                tmpList = idxMap.get(nums[i]);
                tmpList.add(i);
                idxMap.put(nums[i], tmpList);
            } else {
                tmpList = new ArrayList<>();
                tmpList.add(i);
                idxMap.put(nums[i], tmpList);
            }
        }
        
        System.out.println(idxMap);

        int maxDegree = 1;
        int minSubArray = Integer.MAX_VALUE;

        for (int key : idxMap.keySet()) {
            tmpList = idxMap.get(key);
            int size = idxMap.get(key).size();
            int diff = 0;
           System.out.println("size :"+size);
            if (maxDegree < size && size != 1) {
                maxDegree = size;
                minSubArray = tmpList.get(size - 1) - tmpList.get(0)+1;
               
            } else if (maxDegree == size && size != 1) {
                diff = tmpList.get(size - 1) - tmpList.get(0)+1;
                minSubArray = Math.min(minSubArray, diff);

            }

        }
        if(minSubArray==Integer.MAX_VALUE) {
            return 1;
        }
        return minSubArray;

    }

    public static void main(String[] args) {

        MaxDegreeShortestSubarray obj = new MaxDegreeShortestSubarray();
        int[] nums = { 1, 2, 2, 3, 1, 4, 2 };
        System.out.println(obj.findShortestSubArray(nums));

    }

}
