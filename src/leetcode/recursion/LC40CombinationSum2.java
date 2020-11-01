package leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC40CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

           if (i != index && nums[i - 1] == nums[i]) {
                continue;
            }

            partialList.add(nums[i]); // Add the current number into partial List
            dfsHelper(nums, remining_target - nums[i], i + 1, result, partialList); // Subtract the current number from
                                                                                    // target // target , call recursive
            partialList.remove(partialList.size() - 1); // remove the element from partial List and try different
                                                        // combination , Basically backtracking.

        }

    }

    public List<List<Integer>> combinationSum2_Reuse(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(candidates); // to avoid duplicate
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> partialList = new ArrayList<>();
        dfsHelperReuse(candidates, target, 0, result, partialList);
        List<List<Integer>> finalResult = new ArrayList<>();
        for (List<Integer> tmp : result) {
            finalResult.add(tmp);

        }

        return finalResult;

    }

    private void dfsHelperReuse(int[] nums, int remining_target, int index, Set<List<Integer>> result,
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
            dfsHelperReuse(nums, remining_target - nums[i], i + 1, result, partialList); // Subtract the current number from
                                                                                    // target , call recursive
            partialList.remove(partialList.size() - 1); // remove the element from partial List and try different
                                                        // combination , Basically backtracking.

        }

    }

    public static void main(String[] args) {
        LC40CombinationSum2 obj = new LC40CombinationSum2();
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(obj.combinationSum2(candidates, target));

    }

}
