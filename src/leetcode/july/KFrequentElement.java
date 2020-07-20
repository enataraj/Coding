package leetcode.july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> freMap = new HashMap<>();
        Set<Integer> res = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];

            if (freMap.get(key) != null) {

                freMap.put(key, freMap.get(key) + 1);

            } else {
                freMap.put(key, 1);

            }

            if (freMap.get(key) >= k) {
                res.add(key);
            }
        }

        int[] result = new int[res.size()];
        int i = 0;
        for (int num : res) {
            result[i] = num;
            i++;
        }

        return result;

    }

    public static void main(String[] args) {
        KFrequentElement obj = new KFrequentElement();
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int[] res = obj.topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));

    }

}
