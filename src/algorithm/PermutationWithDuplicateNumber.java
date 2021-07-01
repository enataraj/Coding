package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationWithDuplicateNumber {

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        dfsHelper(nums, 0);
        return resultList;

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void dfsHelper(int[] nums, int idx) {
        if (idx >= nums.length) {
            List<Integer> tmpList = new ArrayList<>();
            for (int num : nums) {
                tmpList.add(num);
            }
            System.out.println(tmpList);
            resultList.add(tmpList);
            return;
        }

        for (int i = idx; i < nums.length; i++) {

            if (i > 0 && nums[i] != nums[i - 1]) {
                swap(nums, idx, i);
                dfsHelper(nums, idx + 1);
                swap(nums, idx, i);
            } else {
                swap(nums, idx, i);
                dfsHelper(nums, idx + 1);
                swap(nums, idx, i);
            }

        }

    }

    // Permutation With Visited

    public List<List<Integer>> permuteUniqueSol(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums != null && nums.length > 0) {
            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];

            permuteUnique(nums, used, new ArrayList<>(), result);
        }

        return result;
    }

    private void permuteUnique(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && !used[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }

            used[i] = true;
            list.add(nums[i]);
            permuteUnique(nums, used, list, result);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

}
