package leetcode.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1338ReduceArraySizeHalf {

    public int minSetSize(int[] arr) {
        int result = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int targetSum = arr.length / 2;
        List<Integer> list = new ArrayList<>();
        for (int value : freqMap.values()) {
            list.add(value);
        }
        Collections.sort(list, Collections.reverseOrder());
        int idx = 0;
        while (targetSum > 0) {
            targetSum -= list.get(idx);
            result++;
            idx++;
        }
        return result;
    }

    

    public static void main(String[] args) {
        LC1338ReduceArraySizeHalf obj = new LC1338ReduceArraySizeHalf();
        int[] arr = { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 };
        //int[] arr = { 1000,1000,3,7 };

        System.out.println(obj.minSetSize(arr));
    }

}
