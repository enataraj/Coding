package leetcode.oct;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add("" + nums[0]);
            return result;
        }

        int start = nums[0], end;
        int len = nums.length - 1;

        for (int i = 1; i <= len; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                end = nums[i - 1];
                if (start == end) {
                    result.add(start + "");
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];

            }
        }

        if (nums[len] == nums[len - 1] + 1) {
            result.add(start + "->" + nums[len]);
        } else {
            result.add(nums[len] + "");
        }
        return result;

    }

    public static void main(String[] args) {

        int[] nums = { -1, 1, 2, 4, 5, 6, 8, 10, 11, 12, 13, 17 };
        SummaryRanges obj = new SummaryRanges();
        System.out.println(obj.summaryRanges(nums));

    }

}
