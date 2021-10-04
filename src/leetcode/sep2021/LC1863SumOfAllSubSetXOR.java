package leetcode.sep2021;

import java.util.ArrayList;
import java.util.List;

public class LC1863SumOfAllSubSetXOR {
    int result = 0;
    public int subsetXORSum(int[] nums) {
        dfsHelper(nums, 0, new ArrayList<>());
        return result;
    }

    private void dfsHelper(int[] nums, int start, List<Integer> list) {
        if (start > nums.length) {
            return;
        }
        System.out.println(list);
        int xor = 0;
        for (int num : list) {
            xor ^= num;
        }
        result += xor;

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfsHelper(nums, i + 1, list);
            list.remove(list.size() - 1);
        }

    }
    
    class Solution {
        int sum = 0;
        
        private void findSubset(int[] nums, int curr, int xorVal) {
            if (curr == nums.length) {
                sum += xorVal;
                return;
            }
            findSubset(nums, curr+1, xorVal);
            findSubset(nums, curr+1, xorVal ^ nums[curr]);
        }
        public int subsetXORSum(int[] nums) {
            findSubset(nums, 0, 0);
            return sum;
        }
    }

    public static void main(String[] args) {
        LC1863SumOfAllSubSetXOR obj = new LC1863SumOfAllSubSetXOR();
        int[] nums = { 5,1,6};
        System.out.println(obj.subsetXORSum(nums));
    }
}
