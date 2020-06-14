package general;

import java.util.Arrays;

public class CoinChange {
    int count = 0;

    // Recursive with Meomoraization
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return cc_memo(coins, 0, amount, dp);

    }

    int cc_memo(int[] coins, int i, int amount, int[][] dp) {
        if (amount == 0)
            return 1;
        if (amount < 0 || i == coins.length)
            return 0;
        if (dp[i][amount] != -1)
            return dp[i][amount];

        return dp[i][amount] = cc_memo(coins, i, amount - coins[i], dp) + cc_memo(coins, i + 1, amount, dp);
    }

    // DP Approach Bottom Up
    public int change_bottom_up_dp(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 0; j < amount + 1; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else if (coins[i] > j)
                    dp[i][j] = dp[i + 1][j];
                else
                    dp[i][j] = dp[i][j - coins[i]] + dp[i + 1][j];
            }
        }

        return dp[0][amount];
    }

    // Space Optimization DP Approach
    public int change_bottom_up_dp_space_optimization(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }

    // TLE

    public int change_recursive(int amount, int[] coins) {
        return cc_recursive(coins, 0, amount);
    }

    int cc_recursive(int[] coins, int i, int amount) {
        if (amount == 0)
            return 1;
        if (amount < 0 || i == coins.length)
            return 0;

        return cc_recursive(coins, i, amount - coins[i]) + cc_recursive(coins, i + 1, amount);
    }

    private int possibleways(int amount, int[] coins, int result) {
        count = count + 1;
        if (amount == 0) {
            return result + 1;
        } else if (amount > 0) {
            for (int i = 0; i < coins.length; i++) {

                result = possibleways(amount - coins[i], coins, result);

            }
            return result;
        } else {
            return result;
        }

    }
    
    //  SMART SOLUTION
    
    public int change_smart(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount]; 
    }

    public static void main(String[] args) {
        int amount = 5;
        int coins[] = { 1, 2, 5 };
        // int coins[] = { 1, 5 };
        int possibleWays = new CoinChange().change(amount, coins);
        System.out.println("Answer " + possibleWays);

    }

}
