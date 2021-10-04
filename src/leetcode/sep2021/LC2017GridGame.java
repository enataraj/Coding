package leetcode.sep2021;

public class LC2017GridGame {

    public long gridGame(int[][] grid) {
        long[][] cost = new long[grid.length][grid[0].length];
        cost[0][0] = grid[0][0];
        cost[1][0] = grid[0][0];

        for (int i = 1; i < grid[0].length; i++) {
            cost[0][i] = cost[0][i - 1] + grid[0][i];
            cost[1][i] = cost[1][i - 1] + grid[1][i];
        }

        long top = cost[1][grid[0].length]+cost[0][grid[0].length];
        long bottom = 0;
        long res = Long.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            top -= grid[0][i];
            res = Math.min(res, Math.max(top, bottom));
            bottom += grid[1][i];
        }
        return res;
    }

}
