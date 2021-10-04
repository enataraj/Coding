package leetcode.oct2021;

import java.util.ArrayList;
import java.util.List;

public class LC78SubSet {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        dfsHelper(nums, 0, new ArrayList<>());
        return result;

    }

    private void dfsHelper(int[] nums, int idx, List<Integer> list) {

        result.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            dfsHelper(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
