package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC167TwoSum2 {
    
    
    
    // Since the Array is Sorted we should use that property

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int res[] = new int[2];

        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                res[0] = start;
                res[1] = end;
                return res;
            } else if (numbers[start] + numbers[end] < target) {
                start++;

            } else if (numbers[start] + numbers[end] > target) {
                end--;

            }
        }

        return res;
    }

    public int[] twoSumHM(int[] numbers, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i];
            if (idxMap.containsKey(target - val)) {
                res[0] = idxMap.get(target - val) + 1;
                res[1] = i + 1;
            } else {
                idxMap.put(numbers[i], i);
            }

        }

        return res;
    }
   
    public static void main(String[] args) {
        LC167TwoSum2 obj = new LC167TwoSum2();
        int[] numbers = { 2, 3, 4 };
        int target = 6;
        System.out.println(Arrays.toString(obj.twoSum(numbers, target)));
    }

}
