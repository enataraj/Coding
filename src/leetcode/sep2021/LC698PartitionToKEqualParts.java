package leetcode.sep2021;

public class LC698PartitionToKEqualParts {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % k != 0) {
            return false;
        }
        if (nums.length < k)
            return false;

        int sum = totalSum / k;
        boolean[] visitedIdx = new boolean[nums.length];

        return dfsHelper(nums, 0, visitedIdx, sum, 0, k);

    }

    private boolean dfsHelper(int[] nums, int idx, boolean[] visitedIdx, int sum, int sumSoFar, int k) {
        if (k == 0) {
            return true;
        }

        if (sumSoFar > sum) {
            return false;
        }
        if (sumSoFar == sum) {
            return dfsHelper(nums, 0, visitedIdx, sum, 0, k - 1);
        }

        for (int i = idx; i < nums.length; i++) {
            if (visitedIdx[i])
                continue;
            visitedIdx[i] = true;
            if (dfsHelper(nums, i + 1, visitedIdx, sum, sumSoFar + nums[i], k)) {
                return true;
            }
            visitedIdx[i] = false;
        }
        return false;

    }

    public static void main(String[] args) {
        LC698PartitionToKEqualParts obj = new LC698PartitionToKEqualParts();
        int[] nums = { 4, 3, 2, 3, 5, 2, 1 };
        int k = 4;
        System.out.println(obj.canPartitionKSubsets(nums, k));
    }

}
