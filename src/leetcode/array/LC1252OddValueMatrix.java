package leetcode.array;

public class LC1252OddValueMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        if (indices == null || indices.length == 0) {
            return 0;
        }

        int[][] matrix = new int[n][m];
        int count = 0;

        for (int i = 0; i < indices.length; i++) {
            int row = indices[i][0];
            int col = indices[i][1];

            for (int j = 0; j < m; j++) {
                matrix[row][j] += 1;

            }
            for (int j = 0; j < n; j++) {
                matrix[j][col] += 1;

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public int oddCellsSol(int n, int m, int[][] indices) {

        int[] row = new int[n];
        int[] column = new int[m];
        for (int i = 0; i < indices.length; i++) {
            row[indices[i][0]]++;
            column[indices[i][1]]++;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                res += (row[j] + column[k]) % 2;
            }

        }

        return res;

    }

    public static void main(String[] args) {
        LC1252OddValueMatrix obj = new LC1252OddValueMatrix();
        int n = 2, m = 3;
        int[][] indices = { { 0, 1 }, { 1, 1 } };
        System.out.println(obj.oddCells(n, m, indices));
    }

}
