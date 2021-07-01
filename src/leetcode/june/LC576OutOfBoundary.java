package leetcode.june;

public class LC576OutOfBoundary {

    int MOD = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Long[][][] memo = new Long[m + 1][n + 1][maxMove + 1];
        return (int) dfsHelper(m, n, maxMove, startRow, startColumn, memo);

    }

    private long dfsHelper(int m, int n, int maxMove, int row, int col, Long[][][] memo) {

        if (maxMove < 0) {
            return 0;
        }

        if (row == m || col == n || row < 0 || col < 0) {
            return 1;
        }
        if (memo[row][col][maxMove] != null) {
            return memo[row][col][maxMove];
        }

        long total = 0;
        long left = dfsHelper(m, n, maxMove - 1, row, col - 1, memo);
        long right = dfsHelper(m, n, maxMove - 1, row, col + 1, memo);
        long up = dfsHelper(m, n, maxMove - 1, row - 1, col, memo);
        long down = dfsHelper(m, n, maxMove - 1, row + 1, col, memo);
        total = ((left + right + up + down) % MOD);
        memo[row][col][maxMove] = total;
        return total;

    }

    public static void main(String[] args) {
        LC576OutOfBoundary obj = new LC576OutOfBoundary();
    }

}
