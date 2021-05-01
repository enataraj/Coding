package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class LC46Permutations {
    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        permutation(nums, 0, nums.length - 1);
        return result;

    }

    private void permutation(int[] nums, int left, int right) {
        if (left == right) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);

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

    public List<List<Integer>> permuteAlt(int[] nums) {
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), nums);
        return result;

    }

    private void backtrack(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                backtrack(list, nums);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        LC46Permutations obj = new LC46Permutations();
        int[] nums = { 1, 2, 3, 4 };
        //  System.out.println(obj.permute(nums));
        System.out.println(obj.permuteAlt(nums));
    }

}
