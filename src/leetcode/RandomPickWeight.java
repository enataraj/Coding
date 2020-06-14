package leetcode;

import java.util.Random;

public class RandomPickWeight {

    /*
     * [[[1,3]],[],[],[],[],[]]
     * 
     * 
     */

    public static void main(String[] args) {
        int[] w = { 3, 5, 7, 2, 4 };
        int[] mimicWeight = new int[w.length];
        int limit = 0;
        for (int i = 0; i < w.length; i++) {
            limit = limit + w[i];
            mimicWeight[i] = limit;
            System.out.println(limit);
        }

        System.out.println("Limit : " + limit);
        Random random = new Random();
        int randomNum = 0;

        for (int j = 0; j < limit; j++) {
            randomNum = random.nextInt(limit);
            System.out.println("Random Number  " + randomNum);

            if (randomNum < mimicWeight[0]) {
                System.out.println("Result : 0");
            }
            for (int i = 1; i < mimicWeight.length; i++) {
                if (randomNum >= mimicWeight[i - 1] && randomNum < mimicWeight[i]) {
                    System.out.println("Result : " + i);
                }
            }
        }
    }

}
