package leetcode.weekly.week247;

public class CyclicRotatingGrid {

    public int[][] rotateGridSol2(int[][] matrix, int k) {
        int M = matrix.length;
        int N = matrix[0].length;
        int numRings = Math.min(M, N) / 2;
        for (int i = 0; i < numRings; i++) {
            // Subtract the number of 360 degree rotations from k
            // A 360 degree rotation = rotating the same number of times as the perimeter of the current ring
            int numRotations = k % (2 * (M + N - 4 * i) - 4);
            for (int rotation = 0; rotation < numRotations; rotation++) {
                // Rotate the ring (see the clockwise algorithm for an in-depth example of how this is done)
                // Rotate top row
                for (int j = i; j < N - i - 1; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][j + 1];
                    matrix[i][j + 1] = tmp;
                }
                // Rotate right column
                for (int j = i; j < M - i - 1; j++) {
                    int tmp = matrix[j][N - i - 1];
                    matrix[j][N - i - 1] = matrix[j + 1][N - i - 1];
                    matrix[j + 1][N - i - 1] = tmp;
                }
                // Rotate bottom row
                for (int j = N - i - 1; j > i; j--) {
                    int tmp = matrix[M - i - 1][j];
                    matrix[M - i - 1][j] = matrix[M - i - 1][j - 1];
                    matrix[M - i - 1][j - 1] = tmp;
                }
                // Rotate left column
                for (int j = M - i - 1; j > i + 1; j--) {
                    int tmp = matrix[j][i];
                    matrix[j][i] = matrix[j - 1][i];
                    matrix[j - 1][i] = tmp;
                }
            }
        }
        return matrix;
    }

    public int[][] rotateGridSol(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, r = m, c = n;
        for (int i = 0; i < Math.min(m, n) / 2; i++, r -= 2, c -= 2) {
            int total = 2 * (r + c - 2);
            int k1 = k % total;
            while (k1-- > 0) {
                int tmp = grid[i][i];
                for (int j = i + 1; j < i + c; j++) {
                    grid[i][j - 1] = grid[i][j];
                }
                for (int j = i + 1; j < i + r; j++) {
                    grid[j - 1][i + c - 1] = grid[j][i + c - 1];
                }
                for (int j = i + c - 2; j >= i; j--) {
                    grid[i + r - 1][j + 1] = grid[i + r - 1][j];
                }
                for (int j = i + r - 2; j > i; j--) {
                    grid[j + 1][i] = grid[j][i];
                }
                grid[i + 1][i] = tmp;
            }
        }
        return grid;
    }

    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        grid[1][0] = grid[0][0];
        for (int c = 1; c < n; c++) {
            grid[0][c - 1] = grid[0][c];

        }
        grid[0][n - 1] = grid[1][n - 1];

        k = k % (grid.length * grid[0].length);
        int row = 0, col = 0;
        int prev, curr;

        for (int z = 0; z < k; z++) {
            while (row < m && col < n) {

                if (row + 1 == m || col + 1 == n)
                    break;

                prev = grid[row + 1][col];

                for (int i = col; i < n; i++) {
                    curr = grid[row][i];
                    grid[row][i] = prev;
                    prev = curr;
                }
                row++;

                for (int i = row; i < m; i++) {
                    curr = grid[i][n - 1];
                    grid[i][n - 1] = prev;
                    prev = curr;
                }
                n--;

                if (row < m) {
                    for (int i = n - 1; i >= col; i--) {
                        curr = grid[m - 1][i];
                        grid[m - 1][i] = prev;
                        prev = curr;
                    }
                }
                m--;

                if (col < n) {
                    for (int i = m - 1; i >= row; i--) {
                        curr = grid[i][col];
                        grid[i][col] = prev;
                        prev = curr;
                    }
                }
                col++;
            }
        }
        return grid;
    }
}
