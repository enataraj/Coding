package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    private static int findContiguousArray(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, -1);
        int runningSum =0;
        int arraySize = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==1) {
                runningSum++;
            }else {
                runningSum--;
            }
            if(freqMap.get(runningSum)==null) {
                freqMap.put(runningSum, i);
            }else {
                arraySize = Math.max(arraySize, (i-freqMap.get(runningSum)));
            }
        }
        
       return arraySize;

    }

    public static void main(String[] args) {
        int a[] = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 };
        findContiguousArray(a);

    }

}
