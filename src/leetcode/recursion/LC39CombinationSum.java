package leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC39CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(candidates); // to avoid duplicate
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> partialList = new ArrayList<>();
        dfsHelper(candidates, target, 0, result, partialList);

        return result;

    }

    private void dfsHelper(int[] nums, int remining_target, int index, List<List<Integer>> result,
            List<Integer> partialList) {

        // Base Condition

        if (remining_target == 0) { // Add the partial list to result , because we found one combination of result
            result.add(new ArrayList<>(partialList)); // Add it explicitly , because we are going to use the same
                                                      // partial list for back tracking.
            return; // Since we found one combination return here.

        }

        for (int i = index; i < nums.length && nums[i] <= remining_target; i++) { // Call the dfs recursively until we
                                                                                  // find the answer will combination.
            partialList.add(nums[i]); // Add the current number into partial List
            dfsHelper(nums, remining_target - nums[i], i, result, partialList); // Subtract the current number from
                                                                                // target , call recursive
            partialList.remove(partialList.size() - 1); // remove the element from partial List and try different
                                                        // combination , Basically backtracking.

        }

    }

    public static void main(String[] args) {
        LC39CombinationSum obj = new LC39CombinationSum();
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(obj.combinationSum(candidates, target));

    }

}
