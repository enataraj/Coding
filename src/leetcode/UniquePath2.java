package leetcode;

import java.util.Arrays;

public class UniquePath2 {

    // Simple DFS without Global is not working

    private int pathCount = 0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

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

        dfsHelper(obstacleGrid, 0, 0, rowLen, colLen);
        return pathCount;

    }

    private void dfsHelper(int[][] obstacleGrid, int i, int j, int rowLen, int colLen) {
        if (i == rowLen && j == colLen) {

            pathCount = pathCount + 1;

        }

        if (isValid(i + 1, j, rowLen, colLen, obstacleGrid)) {
            dfsHelper(obstacleGrid, i + 1, j, rowLen, colLen);

        }
        if (isValid(i, j + 1, rowLen, colLen, obstacleGrid)) {
            dfsHelper(obstacleGrid, i, j + 1, rowLen, colLen);

        }

    }

    private boolean isValid(int i, int j, int rowLen, int colLen, int[][] obstacleGrid) {
        if (i >= 0 && i <= rowLen && j >= 0 && j <= colLen) {
            if (obstacleGrid[i][j] == 0) {
                return true;
            }

        }
        return false;

    }

    // DFS with Memo accepted
    public int uniquePathsWithObstaclesMemo(int[][] obstacleGrid) {

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

    // DP solution

    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int m = obstacleGrid.length;

        int n = obstacleGrid[0].length;

        int[][] memoTable = new int[m][n];

        if (obstacleGrid[0][0] == 0)
            memoTable[0][0] = 1;

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0)
                memoTable[i][0] = memoTable[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0)
                memoTable[0][j] = memoTable[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    memoTable[i][j] = memoTable[i - 1][j] + memoTable[i][j - 1];
            }
        }

        return memoTable[m - 1][n - 1];
    }

    public static void main(String[] args) {

        UniquePath2 obj = new UniquePath2();
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println(obj.uniquePathsWithObstaclesMemo(obstacleGrid));

    }

}
