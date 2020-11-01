package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1512NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        List<Integer> indexList = null;
        for (int i = 0; i < nums.length; i++) {
            if (idxMap.containsKey(nums[i])) {
                indexList = idxMap.get(nums[i]);
                indexList.add(i);
                idxMap.put(nums[i], indexList);
            } else {
                indexList = new ArrayList<>();
                indexList.add(nums[i]);
                idxMap.put(nums[i], indexList);

            }
        }

        int res = 0;
        for (List<Integer> tmpValue : idxMap.values()) {
            int n = tmpValue.size() - 1;
            if (n > 0) {
                res = res + ((n * (n + 1)) / 2);
            }
        }
        return res;
    }
    
    
    public int numIdenticalPairsOpt(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int res = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            res += val*(val-1)/2;
        }
        return res;
    }

    public static void main(String[] args) {
        LC1512NumberOfGoodPairs obj = new LC1512NumberOfGoodPairs();
        int[] nums = { 1, 1, 1, 1 };
        System.out.println(obj.numIdenticalPairs(nums));
    }

}
