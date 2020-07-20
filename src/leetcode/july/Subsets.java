package leetcode.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (long i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> subList = new ArrayList<Integer>();
            String binString = String.format("%" + nums.length + "s", Long.toBinaryString(i)).replaceAll(" ", "0");
            System.out.println(binString);
            for (int j = 0; j < nums.length; j++) {

                if (binString.charAt(j) == '1') {
                    subList.add(nums[j]);
                }

            }
            res.add(subList);
        }
        return res;
    }
    
    public List<List<Integer>> subsets_Same(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            int j = 0,
                subsetId = i;
            while (subsetId != 0) {
                if ((subsetId & 1) == 1) {
                    subset.add(nums[j]);
                }
                ++j;
                subsetId >>= 1;
            }
            res.add(subset);
        }
        
        return res;
    }
    
    
    public List<List<Integer>> subsets_recu(int[] nums) {
        return helper(nums, 0);
    }
    
    private List<List<Integer>> helper(int[] nums, int idx) {
        List<List<Integer>> res = new ArrayList<>();
        if (idx == nums.length) {
            res.add(new ArrayList<>());
            return res;
        }
        
        List<List<Integer>> prevPermutations = helper(nums, idx + 1);
        res.addAll(prevPermutations);
        
        for (List<Integer> p : prevPermutations) {
            List<Integer> newPerm = new ArrayList<>();
            newPerm.add(nums[idx]);
            newPerm.addAll(p);
            res.add(newPerm);
        }
        
        return res;
    }
    
    

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Subsets obj = new Subsets();
        List<List<Integer>> res = obj.subsets(nums);
        System.out.println(res.size());
        System.out.println(res);

    }

}
