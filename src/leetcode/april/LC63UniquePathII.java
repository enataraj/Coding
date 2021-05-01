package leetcode.april;

import java.util.Arrays;

public class LC63UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        // Filling dp array row 1 until the obstacles
        for (int i = 0; i < row; i++) {
            dp[0][i] = 0;
            if (obstacleGrid[0][i] != 1)
                dp[0][i] = 1;
            else
                break;
        }

        // Filling dp array col 1 until the obstacles
        for (int i = 0; i < col; i++) {
            dp[i][0] = 0;
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
            else
                break;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[row - 1][col - 1];
    }
    
    
    public int uniquePathsWithObstaclesDFS(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int rowLen = obstacleGrid.length - 1;
        int colLen = obstacleGrid[0].length - 1;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowLen][colLen] == 1) {
            return 0;
        }
        int[][] memo = new int[rowLen + 1][colLen + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfsHelperMemo(obstacleGrid, 0, 0, rowLen, colLen, memo);

    }

    private int dfsHelperMemo(int[][] obstacleGrid, int i, int j, int rowLen, int colLen, int[][] memo) {
        if (memo[i][j] != -1) {
             return memo[i][j];
        }
        if (i == rowLen && j == colLen) {
          return 1;

        }
        int result = 0;
        if (isValid(i + 1, j, rowLen, colLen, obstacleGrid)) {   
            result = result + dfsHelperMemo(obstacleGrid, i + 1, j, rowLen, colLen, memo);
        }
        if (isValid(i, j + 1, rowLen, colLen, obstacleGrid)) {

            result = result + dfsHelperMemo(obstacleGrid, i, j + 1, rowLen, colLen, memo);

        }
        memo[i][j] = result;
        return result;
    }
    
    private boolean isValid(int i, int j, int rowLen, int colLen, int[][] obstacleGrid) {
        if (i >= 0 && i <= rowLen && j >= 0 && j <= colLen) {
            if (obstacleGrid[i][j] == 0) {
                return true;
            }
        }
        return false;
    }


}
