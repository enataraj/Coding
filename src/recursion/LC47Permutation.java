package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC47Permutation {
    Set<List<Integer>> resultSet = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums == null || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        dfsHelper(nums, 0);
        return new ArrayList(resultSet);

    }

    private void dfsHelper(int[] nums, int idx) {
        if (idx == nums.length) {
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                tmpList.add(nums[i]);
            }
            resultSet.add(tmpList);
        }
        System.out.println(Arrays.toString(nums));
        for (int i = idx; i < nums.length; i++) {

            swap(nums, i, idx);
            dfsHelper(nums, idx + 1);
            swap(nums, i, idx);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        LC47Permutation obj = new LC47Permutation();
        int[] nums = { 1, 1, 3 };
        System.out.println(obj.permuteUnique(nums));

    }

}
