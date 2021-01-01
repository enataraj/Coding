package leetcode.dec;

import java.util.Arrays;
import java.util.Collections;

public class LC1463CherryPick2 {

    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, x1 = 0, y1 = 0, y2 = cols - 1;

        int[][][] dp = new int[rows][cols][cols];
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        return helper(grid, dp, 0, 0, cols - 1);
    }

    private int helper(int[][] grid, int[][][] dp, int x1, int y1, int y2) {
        if (x1 == grid.length || !isValid(grid, y1) || !isValid(grid, y2)) {
            return 0;

        } else if (dp[x1][y1][y2] > 0) {
            return dp[x1][y1][y2];

        }

        int ans = Collections.max(Arrays.asList(helper(grid, dp, x1 + 1, y1 - 1, y2 - 1),
                helper(grid, dp, x1 + 1, y1 - 1, y2), helper(grid, dp, x1 + 1, y1 - 1, y2 + 1),
                helper(grid, dp, x1 + 1, y1, y2 - 1), helper(grid, dp, x1 + 1, y1, y2),
                helper(grid, dp, x1 + 1, y1, y2 + 1), helper(grid, dp, x1 + 1, y1 + 1, y2 - 1),
                helper(grid, dp, x1 + 1, y1 + 1, y2), helper(grid, dp, x1 + 1, y1 + 1, y2 + 1)));

        ans += grid[x1][y1];
        if (y1 != y2) {
            ans += grid[x1][y2];
        }

        dp[x1][y1][y2] = ans;
        return ans;
    }

    private boolean isValid(int[][] grid, int y) {
        return y >= 0 && y < grid[0].length;
    }

    public int cherryPickupSol(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] prevMax = new int[cols][cols];

        for (int row = rows - 1; row >= 0; --row) {
            int[][] curMax = new int[cols][cols];

            for (int col1 = Math.min(row + 1, cols) - 1; col1 >= 0; --col1) {
                for (int col2 = Math.max(col1, cols - row - 1); col2 < cols; ++col2) {
                    curMax[col1][col2] = grid[row][col1] + grid[row][col2];

                    int bestPrev = -1;
                    int a = Math.min(cols - 1, col1 + 1);
                    for (int prevCol1 = Math.max(0, col1 - 1); prevCol1 <= a; ++prevCol1) {
                        int b = Math.min(cols - 1, col2 + 1);
                        for (int prevCol2 = Math.max(0, col2 - 1); prevCol2 <= b; ++prevCol2) {
                            bestPrev = Math.max(bestPrev, prevMax[prevCol1][prevCol2]);
                        }
                    }

                    curMax[col1][col2] += bestPrev;
                    curMax[col2][col1] = curMax[col1][col2];
                }
                curMax[col1][col1] -= grid[row][col1];
            }

            prevMax = curMax;
        }

        return prevMax[0][cols - 1];
    }

    public static void main(String[] args) {
        LC1463CherryPick2 obj = new LC1463CherryPick2();
        int[][] grid = { { 1, 0, 0, 0, 0, 0, 1 }, { 2, 0, 0, 0, 0, 3, 0 }, { 2, 0, 9, 0, 0, 0, 0 },
                { 0, 3, 0, 5, 4, 0, 0 }, { 1, 0, 2, 3, 0, 0, 6 } };

    }

}
