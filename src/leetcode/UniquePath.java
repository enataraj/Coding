package leetcode;

import java.util.Arrays;

import array.util.ArrayUtil;

public class UniquePath {

    public int uniquePaths(int m, int n) {

        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
                }
            }
        }

        return mat[m - 1][n - 1];

    }

    public int uniquePathsDfs(int m, int n) {
        return dfs(0, 0, m - 1, n - 1);

    }

    private int dfs(int r, int c, int m, int n) {

        if (r == m && c == n) {
            return 1;
        }
        int result = 0;
        if (r < m) {
            result = result + dfs(r + 1, c, m, n);
        }
        if (c < n) {
            result = result + dfs(r, c + 1, m, n);
        }
        return result;
    }

    public int uniquePathsDfsMemorization(int m, int n) {
        int[][] memo = new int[m - 1][n - 1];
        for (int[] row: memo)
        Arrays.fill(row, -1);
        return dfs_memo(0, 0, m - 1, n - 1, memo);

    }

    private int dfs_memo(int r, int c, int m, int n, int[][] memo) {

        if (memo[r][c] != -1) {
            System.out.println("I m reaching hre");
            return memo[r][c];
        }

        if (r == m && c == n) {
            return 1;
        }
        int result = 0;
        if (r < m) {
            result = result + dfs(r + 1, c, m, n);
           // ArrayUtil.printMatrix(memo);
        }
        if (c < n) {
            result = result + dfs(r, c + 1, m, n);
          //  memo[r][c] = result;
          //  ArrayUtil.printMatrix(memo);
        }

        memo[r][c] = result;
        ArrayUtil.printMatrix(memo);
        return result;
    }

    public static void main(String[] args) {
        
        int r=5,c=5;

        UniquePath obj = new UniquePath();
        int result = obj.uniquePaths(r,c);
        System.out.println("Result : " + result);

        result = obj.uniquePathsDfs(r,c);
        System.out.println("Result : " + result);
        
        result = obj.uniquePathsDfsMemorization(r,c);
        System.out.println("Result : " + result);
    }
}
