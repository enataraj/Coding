package leetcode.matrix;

public class DiagonalSum {

    public int diagonalSum(int[][] mat) {

        if (mat == null || mat.length == 0) {
            return 0;
        }

        if (mat.length == 1 && mat[0].length == 1) {
            return mat[0][0];
        }

        int sum = 0;
        int len = mat.length - 1;

        for (int i = 0; i <= len; i++) {
            sum = sum + mat[i][i];
            if (len - i != i) {
                sum = sum + mat[len - i][i];

            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };

        DiagonalSum obj = new DiagonalSum();
        System.out.println(obj.diagonalSum(mat));
    }

}
