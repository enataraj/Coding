package leetcode.recursion;

public class LC200NumberOfIsLands {
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int result = 0;

    public int numIslands(char[][] grid) {

        int rows = grid.length - 1;
        int cols = grid[0].length - 1;

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    dfsHelper(grid, i, j, rows, cols);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfsHelper(char[][] grid, int row, int col, int rows, int cols) {
        for (int[] dir : dirs) {
            int newR = dir[0] + row;
            int newC = dir[1] + col;
            if (isValid(grid, newR, newC, rows, cols)) {
                grid[newR][newC] = '2';
                dfsHelper(grid, newR, newC, rows, cols);
            }

        }

    }

    private boolean isValid(char[][] grid, int row, int col, int rows, int cols) {
        if (row >= 0 && row <= rows && col >= 0 && col <= cols && grid[row][col] == '1') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LC200NumberOfIsLands obj = new LC200NumberOfIsLands();

        char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };

        System.out.println(obj.numIslands(grid));

    }

}
