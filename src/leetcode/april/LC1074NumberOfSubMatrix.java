package leetcode.april;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1074NumberOfSubMatrix {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        // Row Prefix Sum
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        int result = 0;
        for (int i = 0; i < col; i++) {
            for (int j = i; j < col; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                for (int k = 0; k < row; k++) {
                    sum += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    result += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);

                }
            }
        }
        return result;
    }

    private void pritMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    public static void main(String[] args) {
        LC1074NumberOfSubMatrix obj = new LC1074NumberOfSubMatrix();
        int[][] matrix = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } };
        System.out.println("Matrix");
        obj.pritMatrix(matrix);
        System.out.println();
        int k = 4;
        System.out.println(obj.numSubmatrixSumTarget(matrix, 4));

    }

}
