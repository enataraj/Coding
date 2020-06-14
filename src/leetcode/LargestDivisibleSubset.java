package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 1) {
            return Arrays.asList(nums[0]);
        }
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    count++;

                } else {
                    break;
                }
                if (count == nums.length - 1) {
                    result.add(nums[i]);
                }
            }
        }
        return new ArrayList<Integer>(result);

    }

    public static void main(String[] args) {
        int nums[] = { 3, 4, 16, 8 };
        List<Integer> res = new LargestDivisibleSubset().largestDivisibleSubset(nums);
        System.out.println(res);
    }

}
