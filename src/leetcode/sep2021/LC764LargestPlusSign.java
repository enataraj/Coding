package leetcode.sep2021;

public class LC764LargestPlusSign {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int[][] grid = new int[n][n];
        int result = 0;

        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 1;
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    int curResult = 0;
                    for (int i = 0; i <= n / 2; i++) {
                        boolean canExpand = true;
                        for (int[] dir : dirs) {
                            int newRow = dir[0] * i + row;
                            int newCol = dir[1] * i + col;
                            if (!isValid(grid, newRow, newCol)) {
                                canExpand = false;
                                break;
                            }
                        }
                        if (canExpand) {
                            curResult++;
                        } else {
                            break;
                        }

                    }
                    result = Math.max(result, curResult);
                }

            }
        }
        return result;

    }

    private boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 1;
    }

}
