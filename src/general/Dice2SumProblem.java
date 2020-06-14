package general;

public class Dice2SumProblem {

    private int[][] targetSum(int dice, int face, int sum) {
        int[][] res = new int[face + 1][face + 1];

        
        for (int i = 0; i < res[0].length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[i][j] = i + j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int dice = 2;
        int face = 6;
        int sum = 12;
        int[][] res = new Dice2SumProblem().targetSum(dice, face, sum);
        if (res == null) {
            System.out.println(" No Solution ");
        } else {
            
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

}
