package leetcode.march;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC417PacificAtlanticWaterFlow {

    private int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix==null || matrix.length==0) {
            return Collections.EMPTY_LIST;
        }
        
        
        int m = matrix.length;
        int n = matrix[0].length;

        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            pacificVisited[0][i] = true;
            dfsHelpher(matrix, pacificVisited, 0, i);

        }
        for (int i = 0; i < m; i++) {
            pacificVisited[i][0] = true;
            dfsHelpher(matrix, pacificVisited, i, 0);
        }

        for (int i = 0; i < n; i++) {
            atlanticVisited[m - 1][i] = true;
            dfsHelpher(matrix, atlanticVisited, m - 1, i);

        }
        for (int i = 0; i < m; i++) {
            atlanticVisited[i][n - 1] = true;
            dfsHelpher(matrix, atlanticVisited, i, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    List<Integer> res = new ArrayList();
                    res.add(i);
                    res.add(j);
                    result.add(res);
                }
            }
        }
        return result;

    }

    private void dfsHelpher(int[][] matrix, boolean[][] visited, int i, int j) {

        for (int k = 0; k < dir.length; k++) {
            int nextRow = i + dir[k][0];
            int nextCol = j + dir[k][1];

            if (isValid(nextRow, nextCol, matrix.length, matrix[0].length) && !visited[nextRow][nextCol]
                    && matrix[i][j] <= matrix[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;
                dfsHelpher(matrix, visited, nextRow, nextCol);
            }

        }

    }

    private boolean isValid(int i, int j, int m, int n) {
        if (i >= 0 && i < m && j >= 0 && j < n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LC417PacificAtlanticWaterFlow obj = new LC417PacificAtlanticWaterFlow();
        int[][] matrix = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4, }, { 2, 4, 5, 3, 1, }, { 6, 7, 1, 4, 5, },
                { 5, 1, 1, 2, 4 } };
        System.out.println(obj.pacificAtlantic(matrix));
    }

}
