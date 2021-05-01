package leetcode.april;

public class LC48RotateImage {

    public void rotate(int[][] matrix) {
        // Transpose the Matrix
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // Reverse each row value
        for (int i = 0; i < n; i++) {
            int j = 0;
            int k = n - 1;
            while (j < k) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
                j++;
                k--;
            }
        }
    }

    public void rotateAlt(int[][] matrix) {

        int n = matrix.length;
        int layers = n / 2;
        for (int layer = 0; layer < layers; layer++) {
            int start = layer;
            int end = n - 1 - layer;
            for (int i = start; i < end; i++) {
                // top in tmp
                int tmp = matrix[start][i];
                //left in top
                matrix[start][i] = matrix[n - 1 - i][start];
                // bottom in left
                matrix[n - 1 - i][start] = matrix[end][n - 1 - i];
                //right in bottom
                matrix[end][n - 1 - i] = matrix[i][end];
                //top in right
                matrix[i][end] = tmp;

            }
        }
    }

    public static void main(String[] args) {
        LC48RotateImage obj = new LC48RotateImage();
    }

}
