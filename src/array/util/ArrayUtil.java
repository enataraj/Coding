package array.util;

public class ArrayUtil {

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("  " + matrix[i][j]);
            }
        }
    }

}
