package leetcode.weekly.week245;

public class LC1905CountSubIslands {

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    boolean flag = true;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;

        int rows = grid2.length - 1;
        int cols = grid2[0].length - 1;

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (grid2[i][j] == 1) {
                    grid2[i][j] = 0;
                    dfsHelper(grid2, i, j, rows, cols, grid1);
                    if (flag) {
                        result++;

                    }
                    flag = true;

                }
            }
        }
        return result;
    }

    private void dfsHelper(int[][] grid2, int row, int col, int rows, int cols, int[][] grid1) {
        if (grid1[row][col] == 0) {
            flag = false;
        }
        for (int[] dir : dirs) {
            int newR = dir[0] + row;
            int newC = dir[1] + col;
            if (isValid(grid2, newR, newC, rows, cols)) {
                grid2[newR][newC] = 0;
                dfsHelper(grid2, newR, newC, rows, cols, grid1);

            }

        }

    }

    private boolean isValid(int[][] grid, int row, int col, int rows, int cols) {
        if (row >= 0 && row <= rows && col >= 0 && col <= cols && grid[row][col] == 1) {
            return true;
        }
        return false;
    }

}
