package leetcode.nov;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionSubsetSum {

    public boolean canPartition(int[] nums) {
        int n = nums.length, total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        Set<String> visited = new HashSet<>();
        Arrays.sort(nums);
        return helper(nums, 0, total / 2, visited);
    }

    private boolean helper(int[] nums, int idx, int remaining, Set<String> visited) {
        if (remaining == 0) {
            return true;

        } else if (idx >= nums.length) {
            return false;

        }

        String key = idx + "," + remaining;
        if (visited.contains(key)) {
            return false;
        }

        for (int i = idx; i < nums.length && nums[i] <= remaining; i++) {
            if (helper(nums, i + 1, remaining - nums[i], visited)) {
                return true;
            }
        }

        visited.add(key);
        return false;
    }

    int[] nums;

    public boolean canPartition_Opt(int[] nums) {

        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }

        if (target % 2 == 1)
            return false;
        target /= 2;

        this.nums = nums;

        return dfs(0, target);
    }

    boolean dfs(int i, int target) {
        if (target == 0)
            return true;
        if (target < 0 || i >= nums.length)
            return false;
        if (dfs(i + 1, target - nums[i]))
            return true;
        for (; i + 1 < nums.length && nums[i] == nums[i + 1]; i++);
            
        return dfs(i + 1, target);
    }

    public static void main(String[] args) {
        PartitionSubsetSum obj = new PartitionSubsetSum();
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(obj.canPartition(nums));

    }

}
