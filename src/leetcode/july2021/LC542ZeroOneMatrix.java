package leetcode.july2021;

import java.util.LinkedList;
import java.util.Queue;

public class LC542ZeroOneMatrix {
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    Queue<int[]> queue = new LinkedList<>();

    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : dirs) {
                int newR = dir[0] + row;
                int newC = dir[1] + col;
                if (isValid(mat, newR, newC)) {
                    int distance = mat[row][col] + 1;
                    if (mat[newR][newC] > distance) {
                        mat[newR][newC] = distance;
                        queue.add(new int[] { newR, newC });
                    }
                }
            }
        }

        return mat;
    }

    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        if (i > 0 && j > 0) {
                            mat[i][j] = Math.min(mat[i][j - 1], mat[i - 1][j]) + 1;
                        } else if (j > 0) {
                            mat[i][j] = mat[i][j - 1] + 1;
                        } else if (i > 0) {
                            mat[i][j] = mat[i - 1][j] + 1;
                        } else {
                            mat[i][j] = m + n;
                        }
                    }
                }
            }

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (mat[i][j] > 1) {
                        if (i < m - 1) {
                            mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
                        }
                        if (j < n - 1) {
                            mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
                        }
                    }
                }
            }
            return mat;
        }
    }

    private int findDistance(int[][] mat, int[] cell) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(cell);
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] curCell = queue.poll();
                int row = curCell[0];
                int col = curCell[1];
                for (int[] dir : dirs) {
                    int newR = dir[0] + row;
                    int newC = dir[1] + col;
                    if (isValid(mat, newR, newC)) {
                        if (mat[newR][newC] == 0) {
                            return distance;
                        }
                        queue.add(new int[] { newR, newC });
                    }
                }

            }
        }
        return distance;
    }

    private boolean isValid(int[][] mat, int row, int col) {
        return (row >= 0 && row < mat.length && col >= 0 && col < mat[0].length);
    }

}
