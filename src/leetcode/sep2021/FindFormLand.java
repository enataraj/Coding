package leetcode.sep2021;

import java.util.ArrayList;
import java.util.List;

public class FindFormLand {

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int[] botCor = new int[2];

    public int[][] findFarmland(int[][] land) {

        int rows = land.length - 1;
        int cols = land[0].length - 1;
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (land[i][j] == 1) {
                    botCor = new int[2];
                    botCor[0] = i;
                    botCor[1] = j;
                    land[i][j] = 2;
                    dfsHelper(land, i, j, rows, cols);
                    int[] tmp = { i, j, botCor[0], botCor[1] };
                    resultList.add(tmp);
                }
            }
        }

        int[][] result = new int[resultList.size()][0];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;

    }

    private void dfsHelper(int[][] grid, int row, int col, int rows, int cols) {
        for (int[] dir : dirs) {
            int newR = dir[0] + row;
            int newC = dir[1] + col;
            if (isValid(grid, newR, newC, rows, cols)) {
                grid[newR][newC] = 2;
                botCor[0] = Math.max(botCor[0], newR);
                botCor[1] = Math.max(botCor[1], newC);
                dfsHelper(grid, newR, newC, rows, cols);
            }

        }

    }

    private boolean isValid(int[][] grid, int row, int col, int rows, int cols) {
        if (row >= 0 && row <= rows && col >= 0 && col <= cols && grid[row][col] == 1) {
            return true;
        }
        return false;
    }

}
