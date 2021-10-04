package leetcode.sep2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LC1636SortArrayByInFre {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> tmap = new TreeMap<>();
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (tmap.containsKey(val)) {
                List<Integer> list = tmap.get(val);
                list.add(key);
                tmap.put(val, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                tmap.put(val, list);
            }
        }
        System.out.println(tmap);
        int[] result = new int[nums.length];
        int idx = 0;
        for (int key : tmap.keySet()) {
            List<Integer> list = tmap.get(key);
            Collections.sort(list, Collections.reverseOrder());
            for (int num : list) {
                for (int i = 0; i < key; i++) {
                    result[idx++] = num;
                }

            }
        }

        return result;
    }

    class Solution {
        public int[] frequencySort(int[] nums) {

            //201 because values of array vary between -100 t0 100. 
            // to convert negative values to positive we add 100.
            // so range is 0 to 200 - possible 201 unique values 
            int[] freq = new int[201];
            for (int n : nums) {
                freq[n + 100]++;
            }

            //nums[] = {1, 1, 2, 2, 2, 3}
            //{2099, 2099, 3098, 3098, 3098, 1097}

            for (int i = 0; i < nums.length; i++) {
                nums[i] = freq[nums[i] + 100] * 1000 + (100 - nums[i]);
                // freq on higher digit
                // 100 - nums[i] to sort them in decreasing order 
            }

            Arrays.sort(nums);
            //{1097, 2099, 2099, 3098, 3098, 3098}
            //{3, 1, 1, 2, 2, 2}

            for (int i = 0; i < nums.length; i++) {
                nums[i] = 100 - nums[i] % 1000;
            }

            return nums;
        }
    }

    public static void main(String[] args) {
        LC1636SortArrayByInFre obj = new LC1636SortArrayByInFre();
        int[] nums = { -1, 1, -6, 4, 5, -6, 1, 4, 1 };
        System.out.println(Arrays.toString(obj.frequencySort(nums)));
    }

}
