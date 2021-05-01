package leetcode.topint;

public class LC96UniqueBinaryTree {

    // Solving this is generating catalon number

    public int numTrees(int n) {
        int[] catalon = new int[n + 1];
        catalon[0] = 0;
        catalon[1] = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = 0;
            for (int j = 0; j < i; j++) {
                result += catalon[j] * catalon[i - 1 - j];
            }
            catalon[i] = result;
        }
        return catalon[n];
    }

    /* public int numTrees(int n) {
        int[] catalanNumber = new int[n+1];
    
        catalanNumber[0] = 1;
        catalanNumber[1] = 1;
    
        int result = 0;
    
        for(int i=2 ; i<=n ; i++){
            result = 0;
    
            for(int j=0 ; j< i ;j++) {
                result += catalanNumber[j] * catalanNumber[i-1-j];
            }
    
            catalanNumber[i] = result;
        }
    
        return catalanNumber[n];
    }*/
}
