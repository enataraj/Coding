package leetcode.july2021;

import java.util.Arrays;
import java.util.TreeSet;

public class LC363MaxSumOfRectangle {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ROW = matrix.length;
        int COL = matrix[0].length;
        int[][] sumMatrix = new int[ROW + 1][COL + 1];

        for (int i = 1; i <= ROW; i++) {
            for (int j = 1; j <= COL; j++) {

                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1]
                        + matrix[i - 1][j - 1];

            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= ROW; i++) {
            for (int j = 1; j <= COL; j++) {
                for (int x = i; x <= ROW; x++) {
                    for (int y = j; y <= COL; y++) {
                        int sum = 0;
                        sum = sumMatrix[x][y] - (sumMatrix[i - 1][y] + sumMatrix[x][j - 1] - sumMatrix[i - 1][j - 1]);

                        if (sum <= k) {
                            result = Math.max(result, sum);
                        }
                    }
                }
            }
        }

        return result;
    }

    public int maxSumSubmatrixSol(int[][] matrix, int k) {
        int M = matrix.length, N = matrix[0].length;
        int[][] prefixSumMatrix = matrix.clone();
        computePrefixSum(prefixSumMatrix, M, N);
        return getMaxSum(prefixSumMatrix, M, N, k);
    }

    private int getMaxSum(int[][] prefixSumMatrix, int M, int N, int K) {
        int answer = Integer.MIN_VALUE;
        for (int startCol = 0; startCol < N; startCol++) {
            for (int endCol = startCol; endCol < N; endCol++) {
                TreeSet<Integer> sortedPrexSums = new TreeSet<Integer>();
                sortedPrexSums.add(0);
                int currentPrefixSum = 0;
                for (int row = 0; row < M; row++) {
                    currentPrefixSum += (prefixSumMatrix[row][endCol]
                            - (startCol == 0 ? 0 : prefixSumMatrix[row][startCol - 1]));
                    Integer ceiling = sortedPrexSums.ceiling(currentPrefixSum - K);
                    if (ceiling != null)
                        answer = Math.max(answer, currentPrefixSum - ceiling);
                    sortedPrexSums.add(currentPrefixSum);
                }
            }
        }
        return answer;
    }

    private void computePrefixSum(int[][] prefixSumMatrix, int M, int N) {
        for (int row = 0; row < M; row++)
            for (int col = 1; col < N; col++)
                prefixSumMatrix[row][col] += prefixSumMatrix[row][col - 1];
    }

    private void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int ans = Integer.MIN_VALUE;

            int M = matrix.length;
            int N = matrix[0].length;

            int[][] dp = new int[M + 1][N + 1];

            for (int i = 1; i <= M; ++i) {
                for (int j = 1; j <= N; ++j) {

                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }

            for (int i = 1; i <= M; ++i) {
                for (int j = 1; j <= N; ++j) {
                    for (int x = i; x <= M; ++x) {
                        for (int y = j; y <= N; ++y) {
                            int sum = dp[x][y] - dp[i - 1][y] - dp[x][j - 1] + dp[i - 1][j - 1];

                            if (sum <= k) {
                                ans = Math.max(ans, sum);
                            }
                        }
                    }

                }
            }

            return ans;

        }
    }

    public static void main(String[] args) {

        LC363MaxSumOfRectangle obj = new LC363MaxSumOfRectangle();
        // int[][] matrix = { { 1, 0, 1 }, { 0, -2, 3 } };
        int[][] matrix = { { 5, -4, -3, 4 }, { -3, -4, 4, 5 }, { 5, 1, 5, -4 } };
        System.out.println(obj.maxSumSubmatrix(matrix, 3));
    }
}
