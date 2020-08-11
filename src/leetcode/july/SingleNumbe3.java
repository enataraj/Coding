package leetcode.july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumbe3 {
    public int[] singleNumber(int[] nums) {

        Map<Integer, Integer> freMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freMap.get(nums[i]) != null) {
                freMap.put(nums[i], freMap.get(nums[i]) + 1);
            } else {
                freMap.put(nums[i], 1);
            }

        }

        int res[] = new int[2];
        int idx = 0;
        for (int key : freMap.keySet()) {
            if (freMap.get(key) == 1) {
                res[idx] = key;
                idx++;
            }

        }

        return res;

    }

    public int[] singleNumberOpt(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        System.out.println("XOR Vaklue of Two Numbers " + diff);
        // Get its last set bit
        diff &= -diff;

        System.out.println("Finding the Set Bit " + diff);
        // Pass 2 :
        int[] rets = { 0, 0 }; // this array stores the two numbers we will return
        for (int num : nums) {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
                System.out.println(rets[0]);
            } else // the bit is set
            {
                rets[1] ^= num;
                System.out.println(rets[1]);
            }
        }
        return rets;
    }

    public static void main(String[] args) {

        SingleNumbe3 obj = new SingleNumbe3();
        int[] nums = { 1, 2, 1, 3, 2, 5 };
        int[] res = obj.singleNumber(nums);
        System.out.println(Arrays.toString(res));
        res = obj.singleNumberOpt(nums);
        System.out.println(Arrays.toString(res));

    }

}
