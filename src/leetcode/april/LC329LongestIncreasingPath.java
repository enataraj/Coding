package leetcode.april;

public class LC329LongestIncreasingPath {
    int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    int[][] memo;
    int tmpResult = 1;

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }
        int result = 0;
        memo = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfsHelpher(i, j, row, col, matrix);
                result = Math.max(result, memo[i][j]);
            }
        }
        return result;
    }

    private int dfsHelpher(int i, int j, int row, int col, int[][] matrix) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        memo[i][j] = 1;

        for (int[] dir : dirs) {
            int nextRow = i + dir[0];
            int nextCol = j + dir[1];
            if (isValid(nextRow, nextCol, row, col) && matrix[i][j] < matrix[nextRow][nextCol]) {
                memo[i][j] = Math.max(memo[i][j], 1 + dfsHelpher(nextRow, nextCol, row, col, matrix));
            }

        }
        return memo[i][j];
    }

    private boolean isValid(int i, int j, int row, int col) {
        if (i >= 0 && i < row && j >= 0 && j < col) {
            return true;
        }
        return false;
    }

    //===========================================================================

    public int longestIncreasingPathSol(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) {
            return 0;
        }
        int longest = 1;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longest = Math.max(longest, RecursionMemo(matrix, i, j, memo));
            }
        }
        return longest;
    }

    private int RecursionMemo(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int longest = 0;
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            longest = Math.max(longest, RecursionMemo(matrix, i - 1, j, memo));
        }
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            longest = Math.max(longest, RecursionMemo(matrix, i, j - 1, memo));
        }
        if (i + 1 < matrix.length && matrix[i][j] < matrix[i + 1][j]) {
            longest = Math.max(longest, RecursionMemo(matrix, i + 1, j, memo));
        }
        if (j + 1 < matrix[0].length && matrix[i][j] < matrix[i][j + 1]) {
            longest = Math.max(longest, RecursionMemo(matrix, i, j + 1, memo));
        }
        memo[i][j] = longest + 1;
        return memo[i][j];
    }

    //===========================================================================

    public int longestIncreasingPathNW(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }
        int result = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                tmpResult = 1;
                visited[i][j] = true;
                dfsHelpher(i, j, row, col, visited, matrix);
                result = Math.max(tmpResult, result);

            }
        }

        return result;

    }

    private int dfsHelpher(int i, int j, int row, int col, boolean[][] visited, int[][] matrix) {
        for (int[] dir : dirs) {
            int nextRow = i + dir[0];
            int nextCol = j + dir[1];
            if (isValid(nextRow, nextCol, row, col) && !visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;

                if (matrix[i][j] < matrix[nextRow][nextCol]) {
                    System.out.print("(" + nextRow + "," + nextCol + ")");
                    tmpResult = 1 + dfsHelpher(nextRow, nextCol, row, col, visited, matrix);

                }
            }

        }

        return tmpResult;

    }

    public static void main(String[] args) {
        LC329LongestIncreasingPath obj = new LC329LongestIncreasingPath();
        // int[][] matrix = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
        // int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        int[][] matrix = { { 6, 8 }, { 7, 2 } };
        System.out.println(obj.longestIncreasingPathNW(matrix));

    }

}
