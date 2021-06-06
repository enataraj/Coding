package leetcode.weekly;

import java.util.Arrays;

public class LC1886Determine90Rotated {
    public boolean findRotation(int[][] mat, int[][] target) {

        if (isMatrixEquals(mat, target)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            rotate(mat);
            if (isMatrixEquals(mat, target)) {
                return true;
            }
        }
        return false;

    }

    private void rotate(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat.length; j++) { // Second Loop should start from i;
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            int left = 0;
            int right = mat.length - 1;
            while (left < right) {
                int tmp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = tmp;
                left++;
                right--;
            }

        }

    }

    private boolean isMatrixEquals(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    public static void main(String[] args) {
        LC1886Determine90Rotated obj = new LC1886Determine90Rotated();
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] target = { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(obj.findRotation(mat, target));

    }
}
