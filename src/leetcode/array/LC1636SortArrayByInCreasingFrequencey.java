package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1636SortArrayByInCreasingFrequencey {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }
        System.out.println(freqMap);

        int[] reversMap = new int[nums.length + 1];
        for (int key : freqMap.keySet()) {
            reversMap[freqMap.get(key)] = key;
        }
        
        System.out.println(Arrays.toString(reversMap));

        int idx = 0;
        int res[] = new int[nums.length];
        for (int i = 1; i < reversMap.length; i++) {
            for (int j = 0; j < i; j++) {
                if(reversMap[i]!=0) {
                nums[idx] = reversMap[i];
                idx++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        LC1636SortArrayByInCreasingFrequencey obj = new LC1636SortArrayByInCreasingFrequencey();
        int[] nums = { -1, 1, -6, 4, 5, -6, 1, 4, 1 };
        System.out.println(Arrays.toString(obj.frequencySort(nums)));

    }

}
