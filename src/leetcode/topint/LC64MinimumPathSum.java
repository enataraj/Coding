package leetcode.topint;

import java.util.Arrays;

public class LC64MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int[][] minSumdp = new int[grid.length][grid[0].length];
        minSumdp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            minSumdp[i][0] = minSumdp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            minSumdp[0][i] = minSumdp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                minSumdp[i][j] = grid[i][j] + Math.min(minSumdp[i - 1][j], minSumdp[i][j - 1]);
            }
        }

        return minSumdp[grid.length - 1][grid[0].length - 1];

    }

    private int[][] dp;

    public int minPathSumDFS(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], -1);

        return count(0, 0, grid.length - 1, grid[0].length - 1, grid);
    }

    private int count(int i, int j, int m, int n, int[][] grid) {

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i == m && j == n)
            return grid[i][j];

        if (i > m || j > n)
            return Integer.MAX_VALUE;

        int ans = Math.min(count(i + 1, j, m, n, grid), count(i, j + 1, m, n, grid));

        dp[i][j] = grid[i][j] + ans;

        return dp[i][j];

    }

    public static void main(String[] args) {
        LC64MinimumPathSum obj = new LC64MinimumPathSum();

    }

}
