package leetcode.topint;

import java.util.ArrayList;
import java.util.List;

public class LC448DisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;

    }

    public List<Integer> findDisappearedNumbersAlt(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

}
