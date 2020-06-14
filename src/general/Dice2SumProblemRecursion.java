package general;

public class Dice2SumProblemRecursion {

    private static int[][] targetSum(int i, int j, int sum, int[][] res) {
        if (i != 0) {
            res[i][j] = (i + j);
            targetSum(i - 1, j, sum, res);
        }

        return res;

    }

    public static void main(String[] args) {
        int face = 6;

        int[][] res = new int[face + 1][face + 1];
        int sum = 10;

        for (int j = 0; j <= face; j++) {

            res = targetSum(face, j, sum, res);

        }
        System.out.print("Result for Sum : " + sum + "  is ==> (i,j) ");

        for (int i = 0; i < res[0].length; i++) {
            for (int j = 0; j < res.length; j++) {
                if (res[i][j] == sum) {
                    System.out.print("(" + i + "," + j + ")");

                }
            }

        }

    }

}
