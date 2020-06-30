package leetcode;

public class UniquePath {

    public int uniquePaths(int m, int n) {

        int[][] mat = new int[m][n];
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
                }
            }
        }

        return mat[m - 1][n - 1];

    }

    public static void main(String[] args) {

    }
}
