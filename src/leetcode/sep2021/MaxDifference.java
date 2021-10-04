package leetcode.sep2021;

public class MaxDifference {

    public int maximumDifference(int[] nums) {
        int res = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                res = Math.max(res, nums[i] - nums[j]);
            }
        }
        return res == 0 ? -1 : res;
    }

    public long gridGame(int[][] grid) {
        findCost(grid);
        return findCost(grid);
    }

    public long findCost(int[][] grid) {
        long[][] cost = new long[2][grid[0].length];
        cost[0][0] = grid[0][0];
        cost[1][0] = grid[0][0] + grid[1][0];
        for (int i = 1; i < grid[0].length; i++) {
            cost[0][i] = cost[0][i - 1] + grid[0][i];
            cost[1][i] = Math.max(cost[1][i - 1] + grid[1][i], cost[0][i] + grid[1][i]);

            if (cost[0][i] > cost[1][i]) {
                grid[0][i] = 0;
            } else {
                grid[1][i] = 0;
            }
        }

        if (grid[0][0] > grid[1][0]) {
            grid[0][0] = 0;

        } else {
            grid[1][0] = 0;
        }
        return cost[1][grid[0].length - 1];
    }

}
