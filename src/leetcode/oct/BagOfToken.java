package leetcode.oct;

import java.util.Arrays;

public class BagOfToken {

    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        if (tokens.length == 1) {
            if (tokens[0] <= P) {
                return 1;
            }
            return 0;
        }

        

        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        int score = 0;

        while (i <= j) {
            if (tokens[i] <= P) {
                score += 1;
                P -= tokens[i];
                i++;
            } else if (score > 0 && i!=j) {
                score -= 1;
                P += tokens[j];
                j--;
                
            } else {
                return score;
            }

        }

        return score;

    }

    public static void main(String[] args) {
        BagOfToken obj = new BagOfToken();
        int tokens[] = { 100, 200, 300, 400 };
       int p = 200;
        
        //int tokens[] = { 100, 200 };
       // int p = 150;
        System.out.println(obj.bagOfTokensScore(tokens, p));

    }

}
