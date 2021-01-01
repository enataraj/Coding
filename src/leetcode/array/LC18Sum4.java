package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC18Sum4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        int len = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = nums[i - 1] + nums[i] + nums[j] + nums[j + 1];
                if (target == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i - 1]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[j + 1]);
                    result.add(list);
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        LC18Sum4 obj = new LC18Sum4();
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        System.out.println(obj.fourSum(nums, target));

    }

}
