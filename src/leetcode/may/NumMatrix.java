package leetcode.may;

import java.util.Arrays;

class NumMatrix {
    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        sumMatrix = new int[row + 1][col + 1];
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                sumMatrix[r][c] = sumMatrix[r - 1][c] + sumMatrix[r][c - 1] - sumMatrix[r - 1][c - 1]
                        + matrix[r - 1][c - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1]
                + sumMatrix[row1][col1];
    }
}

class NumMatrix2 {
    int[][] matrixSum;

    public NumMatrix2(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        this.matrixSum = new int[rows + 1][columns + 1];
        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                matrixSum[row][column] = matrixSum[row - 1][column] + matrixSum[row][column - 1]
                        + matrix[row - 1][column - 1] - matrixSum[row - 1][column - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrixSum[row2 + 1][col2 + 1] - matrixSum[row1][col2 + 1] - matrixSum[row2 + 1][col1]
                + matrixSum[row1][col1];
    }
}










class NumMatrix1 {

    int[][] matrix;

    public NumMatrix1(int[][] matrix) {

        // printMat(matrix);
        this.matrix = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = matrix[i][j - 1] + matrix[i][j];
            }

        }
        for (int i = 1; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j];
            }

        }

        // printMat(matrix);
    }

   

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sumOfBigbox = matrix[row2][col2];
        int subtractLeftSide = 0;
        if (col1 != 0) {
            subtractLeftSide = matrix[row2][col1 - 1];
        }
        int subtractTopSide = 0;
        if (row1 != 0) {
            subtractTopSide = matrix[row1 - 1][col2];
        }
        int addBack = 0;
        if (col1 != 0 && row1 != 0) {
            addBack = matrix[row1 - 1][col1 - 1];
        }

        return sumOfBigbox - subtractLeftSide - subtractTopSide + addBack;
    }
    
    private void printMat(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("============");
    }

    public static void main(String[] args) {
        int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 } };
        NumMatrix obj = new NumMatrix(matrix);
    }

}