package leetcode.july2021;

import java.util.Arrays;

public class LC566ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if ((mat.length * mat[0].length) != (r * c) || (mat.length == r && mat[0].length == c)) {
            return mat;
        }

        int curRow = 0;
        int curCol = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[curRow][curCol] = mat[i][j];
                curCol++;
                if (curCol == c) {
                    curRow++;
                    curCol = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC566ReshapeMatrix obj = new LC566ReshapeMatrix();
        int[][] mat = { { 1, 2 }, { 3, 4 } };
        int[][] res = obj.matrixReshape(mat, 1, 4);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

}
