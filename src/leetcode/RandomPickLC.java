package leetcode;

import java.util.Random;

class RandomPickLC {
    private int[] w;
    public RandomPickLC(int[] w) {
        this.w = w;

    }

    public int pickIndex() {
        int[] mimicWeight = new int[w.length];
        int limit = 0;
        int result = 0;
        for (int i = 0; i < w.length; i++) {
            limit = limit + w[i];
            mimicWeight[i] = limit;
            // System.out.println(limit);
        }

        // System.out.println("Limit : " + limit);
        Random random = new Random();
        int randomNum = 0;

        randomNum = random.nextInt(limit);
        // System.out.println("Random Number " + randomNum);

        if (randomNum < mimicWeight[0]) {
            return result;
        }
        for (int i = 1; i < mimicWeight.length; i++) {
            if (randomNum >= mimicWeight[i - 1] && randomNum < mimicWeight[i]) {
                result = i;
                break;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] w = { 3, 5, 7, 2, 4 };
        RandomPickLC obj = new RandomPickLC(w);
        for (int i = 0; i < 21; i++) {
            int param_1 = obj.pickIndex();
            System.out.print("  "+param_1);
        }
    }
}