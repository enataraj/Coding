package leetcode;

public class KanpSack01Example {
    int result = Integer.MAX_VALUE;

    public int findMinDifferenceFromGoal(int[] nums, int goal) {
        kanpsackSubSequenceSum(nums, 0, goal, 0);

        return result;
    }

    private void kanpsackSubSequenceSum(int[] nums, int idx, int goal, int sum) {
        if (idx >= nums.length) {
            result = Math.min(result, Math.abs(sum - goal));
        }
        // Not including the current idx value (0 case in 0/1 knapsack)
        kanpsackSubSequenceSum(nums, idx + 1, goal, sum);

        // Including the current idx value (1 case in 0/1 knapsack)

        kanpsackSubSequenceSum(nums, idx + 1, goal, sum + nums[idx]);

    }

    public static void main(String[] args) {
        KanpSack01Example obj = new KanpSack01Example();

    }

}
