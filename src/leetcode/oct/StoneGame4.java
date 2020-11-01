package leetcode.oct;

public class StoneGame4 {

    public boolean winnerSquareGame_Dp(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            // If at least one choice lead to LOSE - then this state is WIN
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public boolean winnerSquareGame_DP_Optimized(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            // If at least one choice lead to LOSE - then this state is WIN
            for (int j = (int) Math.sqrt(i); j >= 1; j--) {
                if (!dp[i - j * j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public boolean winnerSquareGame(int n) {
        Boolean[] cache = new Boolean[n + 1];
        return dfsHelper(n, cache);

    }

    private boolean dfsHelper(int n, Boolean[] cache) {
        if (n == 0) {
            return false;
        }
        if (cache[n] != null) {
            return cache[n];
        }

        boolean result = false;
        for (int i = 1; i * i <= n; i++) { // i = 1

            if (!dfsHelper(n - i * i, cache)) {
                result = true;
                break;
            }
        }

        cache[n] = result;
        return result;
    }
    
    public boolean winnerSquareGame_Dp2(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= n; i++){
            if (dp[i]){
                continue;
            }
            for (int k = 1; i + k * k <= n; k++){
                dp[i+k*k] = true;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        StoneGame4 obj = new StoneGame4();
        System.out.println(obj.winnerSquareGame(16));

    }

}
