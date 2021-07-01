package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationExample {

    private void generatePermuatation(int[] nums) {
        permutation(nums, 0, nums.length - 1);
    }

    private void permutation(int[] nums, int left, int right) {
        if (left == right) {
            System.out.println(Arrays.toString(nums));
        }

        for (int i = left; i <= right; i++) {
            swap(nums, left, i);
            permutation(nums, left + 1, right);
            swap(nums, left, i);

        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // Alternate without Swap Using ArrayList

    public List<List<Integer>> permuteWithoutSwap(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums != null && nums.length > 0) {
            permuteUnique(nums, new ArrayList<>(), result);
        }
        return result;
    }

    private void permuteUnique(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            permuteUnique(nums, list, result);
            list.remove(list.size() - 1);
        }
    }

}
