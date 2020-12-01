package leetcode.nov;

public class InvertMatrix {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        for (int i = 0; i < A.length; i++) {
            int j = 0, k = A[0].length - 1;
            while (j <= k) {
                int tmp = A[i][k];
                A[i][k] = getReverse(A[i][j]);
                A[i][j] = getReverse(tmp);
                j++;
                k--;

            }
        }

        return A;

    }

    private int getReverse(int val) {
        if (val == 1) {
            return 0;
        }
        return 1;
    }
    
    
    private static void printMatrix (int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        InvertMatrix obj = new InvertMatrix();
        int A[][] = { { 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1 }, { 0, 1, 0, 1, 0 } };
        printMatrix(A);
        int B[][] = obj.flipAndInvertImage(A);
      
        System.out.println();
        printMatrix(B);

    }

}
