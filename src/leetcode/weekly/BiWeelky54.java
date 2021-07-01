package leetcode.weekly;

import java.util.HashSet;
import java.util.Set;

public class BiWeelky54 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < ranges.length; i++) {
            for (int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                set.add(j);
            }
        }
        for (int i = left; i <= right; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }
        long remin_k = k % sum;
        if (remin_k == 0) {
            return 0;
        }
        int idx = 0;

        for (idx = 0; idx < chalk.length; idx++) {
            remin_k = remin_k - chalk[idx];
            if (remin_k < 0) {
                return idx;
            }
        }
        return -1;

    }

    int cnt = 0;

    public int largestMagicSquare(int[][] grid) {
        int result = 1;

        int maxLen = Math.min(grid.length, grid[0].length);
        if (maxLen == 1) {
            return 1;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                cnt = 1;
                isValid(grid, i, j, 0, 0, 0, i, j);
                result = Math.max(result, cnt);
            }
        }
        return result;
    }

    private void isValid(int[][] grid, int startRow, int startCol, int rowSum, int colSum, int diaSum, int row,
            int col) {
        if ((row < grid.length && col < grid[0].length)) {

            rowSum += grid[startRow][col];
            colSum += grid[row][startCol];
            diaSum += grid[row][col];
            if (rowSum == colSum && rowSum == diaSum) {
                cnt += 1;
                isValid(grid, startRow, startCol, rowSum, colSum, diaSum, row + 1, col + 1);
            }
        }
        return;

    }

    public static void main(String[] args) {
        BiWeelky54 obj = new BiWeelky54();
        int[][] ranges = { { 1, 1 } };
        int left = 1;
        int right = 50;
        System.out.println(obj.isCovered(ranges, left, right));
    }

}
