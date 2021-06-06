package leetcode.topint;

public class LC494TargetSum {

    int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfsHelper(nums, target, 0, 0);
        return result;
    }

    private void dfsHelper(int[] nums, int target, int idx, int curSum) {
        if (idx == nums.length) {
            if (curSum == target) {
                result++;
            }
            return;
        }

        dfsHelper(nums, target, idx + 1, curSum + nums[idx]);
        dfsHelper(nums, target, idx + 1, curSum - nums[idx]);

    }

    public static void main(String[] args) {
        LC494TargetSum obj = new LC494TargetSum();
    }

}
